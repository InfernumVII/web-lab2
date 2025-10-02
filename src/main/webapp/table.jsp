<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/table-styles.css">
        <title>tableView</title>
        <script src="table.js"></script>
    </head>
    <body>
        <div class="particles" id="particles"></div>
        <div id="content">
            <div id="info-table">
                <table>
                    <tr>
                        <th>x</th>
                        <th>y</th>
                        <th>R</th>
                        <th>currentTime</th>
                        <th>timeExecution</th>
                        <th>Success</th>
                    </tr>
                    <c:forEach var="item" items="${tableC.getHistory()}">
                        <tr>
                            <td>${item.getCords().getX().toPlainString()}</td>
                            <td>${item.getCords().getY()}</td>
                            <td>${item.getCords().getR()}</td>
                            <td>${item.getCurrentTimeSeconds()}</td>
                            <td>${item.getTimeExecution()}</td>
                            <td>${item.isSuccess()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <form action="/">
            <input class="back" type="submit" value="<--" />
        </form>
    </body>
</html>