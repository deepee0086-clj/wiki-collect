(ns wiki-collect.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as rf]
            [reframe-utils.core :refer [reg-basic-sub]]))


(reg-basic-sub :name)
(reg-basic-sub :collections)
(reg-basic-sub :selected-collection)

(rf/reg-sub
 :collection-count
 :<- [:collections]
 (fn [c [_]] (count c)))
