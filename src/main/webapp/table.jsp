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
                    <c:forEach var="item" items="${tableC.history}">
                        <tr>
                            <td>${item.cords.x.toPlainString()}</td>
                            <td>${item.cords.y}</td>
                            <td>${item.cords.r}</td>
                            <td>${item.currentTimeSeconds}</td>
                            <td>${item.timeExecution} micros</td>
                            <td>${item.success}</td>
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