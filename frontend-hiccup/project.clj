(defproject frontend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [clj-time "0.9.0"]
                 [cheshire "5.4.0"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [clj-http "1.0.1"]]
  :plugins [[lein-ring "0.8.12"]]
  :ring {:handler frontend.handler/app
         :init frontend.handler/init
         :destroy frontend.handler/destroy}
  :main ^:skip-aot frontend.handler
  :uberjar-name "frontend.jar"
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}})
