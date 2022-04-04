package com.example.domaci4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

@WebServlet(name = "summary", value = "/summary")
public class SummaryServlet extends HttpServlet {
    private String pass;
    private String html;
    private String wrong;
    private ArrayList<String> ponedeljak = new ArrayList<>();
    private ArrayList<String> utorak = new ArrayList<>();
    private ArrayList<String> sreda = new ArrayList<>();
    private ArrayList<String> cetvrtak = new ArrayList<>();
    private ArrayList<String> petak = new ArrayList<>();
    public void init(){
        setPassword();
        getPonedeljak();
        getUtorak();
        getSreda();
        getCetvrtak();
        getPetak();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        if(req.getParameter("lozinka").equals(pass)){
            out.println(renderPage());
        }else{
            out.println(renderWrong());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("------>ponedeljak"));
    }

    private void setPassword() {
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\password.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                pass = data;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void getPonedeljak(){
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\ponedeljak.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                ponedeljak.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getUtorak(){
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\utorak.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                utorak.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getSreda(){
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\sreda.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                sreda.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getCetvrtak(){
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\cetvrtak.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                cetvrtak.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getPetak(){
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\petak.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                petak.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String renderWrong(){
        wrong = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Wrong Password</title>\n" +
                "</head>\n" +
                "<style>\n" +
                "    h1{\n" +
                "        font-weight: bold;\n" +
                "    }\n" +
                "</style>\n" +
                "<body style=\"margin: auto; width: 20%; padding: 10px;\">\n" +
                "    <h1>WRONG PASSWORD!!!</h1>    \n" +
                "</body>\n" +
                "</html>";
        return wrong;
    }
    private String renderPage(){
        html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Order Summary</title>\n" +
                "</head>\n" +
                "<style>\n" +
                "    input[type=text], select {\n" +
                "      width: 100%;\n" +
                "      padding: 12px 20px;\n" +
                "      margin: 8px 0;\n" +
                "      display: inline-block;\n" +
                "      border: 1px solid #ccc;\n" +
                "      border-radius: 4px;\n" +
                "      box-sizing: border-box;\n" +
                "    }\n" +
                "    \n" +
                "    input[type=submit] {\n" +
                "      width: 100%;\n" +
                "      background-color: rgb(161, 66, 66);\n" +
                "      color: white;\n" +
                "      padding: 14px 20px;\n" +
                "      margin: 8px 0;\n" +
                "      border: none;\n" +
                "      border-radius: 4px;\n" +
                "      cursor: pointer;\n" +
                "    }\n" +
                "    \n" +
                "    input[type=submit]:hover {\n" +
                "      background-color: rgb(180, 92, 92);\n" +
                "    }\n" +
                "    \n" +
                "    div {\n" +
                "      border-radius: 5px;\n" +
                "      background-color: #f2f2f2;\n" +
                "      padding: 20px;\n" +
                "    }\n" +
                "    label{\n" +
                "        text-align: left;\n" +
                "    }\n" +
                "    h1{\n" +
                "      text-align: center;\n" +
                "      font-weight: bold;\n" +
                "    }\n" +
                "    h2{\n" +
                "      text-align: left;\n" +
                "    }\n" +
                "    table {\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "\n" +
                "th, td {\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "\n" +
                "tr:nth-child(even){background-color: #f2f2f2}\n" +
                "\n" +
                "th {\n" +
                "  background-color: #2683c0;\n" +
                "  color: white;\n" +
                "}\n" +
                "    </style>\n" +
                "<body style=\"margin: auto; width: 20%; padding: 10px;\">\n" +
                "    <h1>Odabrana jela</h1>\n" +
                "    <input type=\"submit\" value=\"Clear\">\n" +
                "    <h2>Ponedeljak</h2>\n" +
                "    <table>\n" +
                "      <tr>\n" +
                "        <th>#</th>\n" +
                "        <th>Jelo</th>\n" +
                "        <th>Kolicina</th>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>1</td>\n" +
                "        <td>" + ponedeljak.get(0) + "</td>\n" +
                "        <td>Germany</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>2</td>\n" +
                "        <td>" + ponedeljak.get(1) + "</td>\n" +
                "        <td>Mexico</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>3</td>\n" +
                "        <td>" + ponedeljak.get(2) + "</td>\n" +
                "        <td>Austria</td>\n" +
                "      </tr>\n" +
                "      </table>\n" +
                "      \n" +
                "\n" +
                "      <h2>Utorak</h2>\n" +
                "    <table>\n" +
                "      <tr>\n" +
                "        <th>#</th>\n" +
                "        <th>Jelo</th>\n" +
                "        <th>Kolicina</th>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>1</td>\n" +
                "        <td>Maria Anders</td>\n" +
                "        <td>Germany</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>2</td>\n" +
                "        <td>Francisco Chang</td>\n" +
                "        <td>Mexico</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>3</td>\n" +
                "        <td>Roland Mendel</td>\n" +
                "        <td>Austria</td>\n" +
                "      </tr>\n" +
                "      </table>\n" +
                "\n" +
                "      <h2>Sreda</h2>\n" +
                "    <table>\n" +
                "      <tr>\n" +
                "        <th>#</th>\n" +
                "        <th>Jelo</th>\n" +
                "        <th>Kolicina</th>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>1</td>\n" +
                "        <td>Maria Anders</td>\n" +
                "        <td>Germany</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>2</td>\n" +
                "        <td>Francisco Chang</td>\n" +
                "        <td>Mexico</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>3</td>\n" +
                "        <td>Roland Mendel</td>\n" +
                "        <td>Austria</td>\n" +
                "      </tr>\n" +
                "      </table>\n" +
                "\n" +
                "      <h2>Cetvrtak</h2>\n" +
                "    <table>\n" +
                "      <tr>\n" +
                "        <th>#</th>\n" +
                "        <th>Jelo</th>\n" +
                "        <th>Kolicina</th>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>1</td>\n" +
                "        <td>Maria Anders</td>\n" +
                "        <td>Germany</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>2</td>\n" +
                "        <td>Francisco Chang</td>\n" +
                "        <td>Mexico</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>3</td>\n" +
                "        <td>Roland Mendel</td>\n" +
                "        <td>Austria</td>\n" +
                "      </tr>\n" +
                "      </table>\n" +
                "\n" +
                "      <h2>Petak</h2>\n" +
                "    <table>\n" +
                "      <tr>\n" +
                "        <th>#</th>\n" +
                "        <th>Jelo</th>\n" +
                "        <th>Kolicina</th>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>1</td>\n" +
                "        <td>Maria Anders</td>\n" +
                "        <td>Germany</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>2</td>\n" +
                "        <td>Francisco Chang</td>\n" +
                "        <td>Mexico</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>3</td>\n" +
                "        <td>Roland Mendel</td>\n" +
                "        <td>Austria</td>\n" +
                "      </tr>\n" +
                "      </table>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>";
        return html;
    }
}
