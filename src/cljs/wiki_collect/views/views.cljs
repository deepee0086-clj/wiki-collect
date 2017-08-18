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

(def content-tree []
  (let [collections-count (rf subscribe [:collections])]
    ))


(defn main-panel []
  (let [name (rf/subscribe [:name])]
    (fn []
      [:div
       [collection-counter]
       [:span "Currently viewing: " (normal-title "Kosh_Naranek")]])))
