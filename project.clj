;;;; This file is part of gorilla-repl. Copyright (C) 2014-, Jony Hudson.
;;;;
;;;; gorilla-repl is licenced to you under the MIT licence. See the file LICENCE.txt for full details.

(defproject hellonico/gorilla-repl "0.4.1"
  :description "A rich REPL for Clojure in the notebook style."
  :url "https://github.com/JonyEpsilon/gorilla-repl"
  :license {:name "MIT"}
  :repositories [
    ["vendredi" {:url "https://repository.hellonico.info/repository/hellonico/" :creds :gpg}]
  ]
  :release-tasks [["vcs" "assert-committed"]
                ["change" "version" "leiningen.release/bump-version" "release"]
                ["vcs" "commit"]
                ["vcs" "tag" "--no-sign"]
                ["deploy" "vendredi"]
                ["change" "version" "leiningen.release/bump-version"]
                ["vcs" "commit"]
                ["vcs" "push"]
                ]
  :dependencies ^:replace [[org.clojure/clojure "1.9.0"]
                           [http-kit "2.3.0"]
                           [ring/ring-json "0.4.0"]
                           [cheshire "5.8.1"]
                           [compojure "1.6.1"]
                           [org.slf4j/slf4j-api "1.7.25"]
                           [ch.qos.logback/logback-classic "1.2.3"]
                           [gorilla-renderable "2.0.0"]
                           [gorilla-plot "0.1.4"]
                           [javax.servlet/servlet-api "2.5"]
                           [grimradical/clj-semver "0.3.0" :exclusions [org.clojure/clojure]]
                           [cider/cider-nrepl "0.18.0"]
                           [org.clojure/tools.nrepl "0.2.13"]]
  :main ^:skip-aot gorilla-repl.core
  :target-path "target/%s")
