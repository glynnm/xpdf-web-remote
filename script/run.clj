(use 'ring.adapter.jetty)
(require 'xpdf-web-remote.core)

(run-jetty 'xpdf-web-remote/app {:port 8080})
