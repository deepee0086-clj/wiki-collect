(ns wiki-collect.events
  (:require [re-frame.core :as rf]
            [wiki-collect.db :as db]))

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   db/default-db))

(def interceptors [rf/trim-v])

;; Usage (dispatch :change-selected-title "title")
(rf/reg-event-db
 :change-selected-title
 interceptors
 (fn [db [title]]
   (assoc-in db [:selected-collection] title)))
