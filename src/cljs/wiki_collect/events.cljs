(ns wiki-collect.events
  (:require [re-frame.core :as re-frame]
            [wiki-collect.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
