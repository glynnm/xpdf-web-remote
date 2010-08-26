(ns xpdf-web-remote.core
  (:use compojure.core, ring.adapter.jetty)
  (:require [compojure.route :as route])
  (:use clojure.contrib.shell-out)
  (:use ring.middleware.reload)
  (:use ring.middleware.stacktrace)
  (:use ring.util.response)
  (:use ring.middleware.file)
  (:use ring.middleware.file-info))

(def *xpdf-remote-name* "shared")

(defn xpdf-remote [action]
  (sh "xpdf" "-remote" *xpdf-remote-name* "-exec" action))

(defroutes main-routes
  (POST "/" [action] (xpdf-remote action)))

(def app
  (-> main-routes
    (wrap-file "public")
    (wrap-file-info)
    (wrap-reload '[xpdf-web-remote.core])
    (wrap-stacktrace)))
