package co.edu.escuelaing.aws;


import static spark.Spark.*;

public class Webspark {

    public static void main(String[] args) {
        getPort();
        HttpConnection httpconnection = new HttpConnection();

        get("/palindromo", (request, response) -> {
            response.type("Application/json");
            String cadena = String.valueOf(request.queryParams("value"));
            System.out.println(cadena);
            return httpconnection.conectApi(cadena);
        });

        get("/index.html", (request, response) -> {
            return getIndex();
        });

    }
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    static String getIndex(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Form Example</title>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Form with GET</h1>\n" +
                "<form action=\"/hello\">\n" +
                "    <label for=\"valor\">Ingrese palindromo:</label><br>\n" +
                "    <input type=\"text\" id=\"valor\" name=\"valor\" value=\"aadbaeeabdaa\"><br><br>\n" +
                "    <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" +
                "</form>\n" +
                "<div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "<script>\n" +
                "            function loadGetMsg() {\n" +
                "                let valor = document.getElementById(\"valor\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg\").innerHTML = this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/palindromo?value=\"+valor);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "</body>\n" +
                "</html>";
    }


}
