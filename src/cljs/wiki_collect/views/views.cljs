(ns wiki-collect.views
  (:require [re-frame.core :as rf]
            [clojure.string :as string]))

(defn normal-title [val] (string/replace val #"_" " "))

;;;; Collection overview
(defn collection-counter []
  (let [collections-count (rf/subscribe [:collection-count])
        plural (> @collections-count 1)]
    (fn []
      [:div.counter [:span "You have " @collections-count " collection" (if plural "s") ]])))

;; TODO: Make the links actions that either fetch from cache or lazy load from http.
(defn- change-selected
  [title]
  (js/console.log "title: " title)
  (rf/dispatch [:change-selected-title title]))

(defn- collection-list-item
  [{:keys [title]}]
  (let [title-display (normal-title title)]
    [:li
     [:a
      {:href "#"
       :on-click #(change-selected title)}
      title-display]]))

(defn collection-list
  []
  (let [collections @(rf/subscribe [:collections])]
    [:div
     [:ul
      (map
       collection-list-item
       collections)]]))

(defn collection-viewer
  []
  (let [selected-collection @(rf/subscribe [:selected-collection])]
    [:span "Currently viewing: " (normal-title selected-collection)]))

(defn main-panel []
  []
  (fn []
    [:div
     [collection-counter]
     [collection-list]
     [collection-viewer]]))
