(defproject xpdf-web-remote "1.0.0-SNAPSHOT"
  :description "Web interface for Xpdf remote mode"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [compojure "0.4.1"]
                 [ring/ring-jetty-adapter "0.2.5"]
                 [ring/ring-devel "0.2.5"]]
  :repl-init-script "script/run.clj"
  :main xpdf-web-remote.core)
