<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/styles.css">
        <title>web-lab2</title>
        <script src="script.js"></script>
    </head>
    <body>
        <div class="particles" id="particles"></div>
        <div id="header">
            <head>
                <link rel="stylesheet" href="css/header-styles.css">
            </head>
            <div class="header-item" id="full-name">ФИО: Швецов Егор Максимович</div>
            <div class="header-item" id="group-number">Номер группы: P3206</div>
            <div class="header-item" id="variant">Вариант: 468074</div>
        </div>
        <div id="content">
            <head>
                <link rel="stylesheet" href="css/content-styles.css">
            </head>
            <div class="first-row">
                <div class="chart">
                    <svg width="440" height="440">
                        <!-- <rect x="10" y="10" width="30" height="30" stroke="black" fill="transparent" stroke-width="5"/>
                        <rect x="60" y="10" rx="10" ry="10" width="30" height="30" stroke="black" fill="transparent" stroke-width="5"/>
                        
                        
                        <ellipse cx="75" cy="75" rx="20" ry="5" stroke="red" fill="transparent" stroke-width="5"/> -->
                        
                        <polygon class="figures" points="220,220 220,132 132,220"></polygon>
                        <rect class="figures" x="220" y="132" width="176" height="88"/>
                        <defs>
                            <clipPath id="half-half-circle">
                                <rect x="220" y="220" width="88" height="88"/>
                            </clipPath>
                        </defs>
                        <circle class="figures" cx="220" cy="220" r="88" clip-path="url(#half-half-circle)"/>
                        <!--y strokes plus-->
                        <line x1="215" x2="225" y1="132" y2="132" stroke="white" fill="transparent" stroke-width="1"/>
                        <text x="226" y="134">R/2</text>
                        <line x1="215" x2="225" y1="44" y2="44" stroke="white" fill="transparent" stroke-width="1"/>
                        <text x="226" y="46">R</text>
                        <!--y strokes minus-->
                        <line x1="215" x2="225" y1="308" y2="308" stroke="white" fill="transparent" stroke-width="1"/>
                        <text x="226" y="310">-R/2</text>
                        <line x1="215" x2="225" y1="396" y2="396" stroke="white" fill="transparent" stroke-width="1"/>
                        <text x="226" y="398">-R</text>
                        <!--y arrow -->
                        <text x="225" y="10">y</text>
                        <line x1="220" x2="220" y1="440" y2="0" stroke="white" fill="transparent" stroke-width="1"/>
                        <line x1="220" x2="215" y1="0" y2="5" stroke="white" fill="transparent" stroke-width="1"/>
                        <line x1="220" x2="225" y1="0" y2="5" stroke="white" fill="transparent" stroke-width="1"/>
                        
                        <!--x strokes plus-->
                        <line x1="308" x2="308" y1="215" y2="225" stroke="white" fill="transparent" stroke-width="1"/>
                        <text x="304" y="213">R/2</text>
                        <line x1="396" x2="396" y1="215" y2="225" stroke="white" fill="transparent" stroke-width="1"/>
                        <text x="392" y="213">R</text>
                        <!--x strokes minus-->
                        <line x1="132" x2="132" y1="215" y2="225" stroke="white" fill="transparent" stroke-width="1"/>
                        <text x="128" y="213">-R/2</text>
                        <line x1="44" x2="44" y1="215" y2="225" stroke="white" fill="transparent" stroke-width="1"/>
                        <text x="40" y="213">-R</text>
                        <!--x arrow -->
                        <text x="430" y="235">x</text>
                        <line x1="0" x2="440" y1="220" y2="220" stroke="white" fill="transparent" stroke-width="1"/>
                        <line x1="440" x2="435" y1="220" y2="215" stroke="white" fill="transparent" stroke-width="1"/>
                        <line x1="440" x2="435" y1="220" y2="225" stroke="white" fill="transparent" stroke-width="1"/>
                        
                        
                        <!-- <line x1="220" x2="220" y1="440" y2="0" stroke="white" fill="transparent" stroke-width="1"/> -->
                        <!-- <polyline points="60 110 65 120 70 115 75 130 80 125 85 140 90 135 95 150 100 145"
                            stroke="orange" fill="transparent" stroke-width="5"/>
                        
                        <polygon points="50 160 55 180 70 180 60 190 65 205 50 195 35 205 40 190 30 180 45 180"
                            stroke="green" fill="transparent" stroke-width="5"/>
                        
                        <path d="M20,230 Q40,205 50,230 T90,230" fill="none" stroke="blue" stroke-width="5"/> -->
                        <!---->
                        <circle class="point" cx="220" cy="220" r="5"/>
                    </svg>
                </div>
                
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
            

            <form action="/api" method="get" class="xyR-form">
                <fieldset>
                    <legend>X</legend>
                    <div id="input-text-error"></div>
                    <div class="xyR-form">
                        <input id="input-x" type="text" placeholder="Enter x cord: " oninput="onInputTextUpdate(this.value)" value="1" maxlength="10" name="x">
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Y</legend>
                    <div class="xyR-form">
                        <input type="radio" id="choice-1" name="y" value="-3"/>
                        <label for="choice-1">-3</label>
                        <input type="radio" id="choice-2" name="y" value="-2"/>
                        <label for="choice-2">-2</label>
                        <input type="radio" id="choice-3" name="y" value="-1"/>
                        <label for="choice-3">-1</label>
                        <input type="radio" id="choice-4" name="y" value="0" checked/>
                        <label for="choice-4">0</label>
                        <input type="radio" id="choice-5" name="y" value="1"/>
                        <label for="choice-5">1</label>
                        <input type="radio" id="choice-6" name="y" value="2"/>
                        <label for="choice-6">2</label>
                        <input type="radio" id="choice-7" name="y" value="3"/>
                        <label for="choice-7">3</label>
                        <input type="radio" id="choice-8" name="y" value="4"/>
                        <label for="choice-8">4</label>
                        <input type="radio" id="choice-9" name="y" value="5"/>
                        <label for="choice-9">5</label>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>R</legend>
                    <div class="xyR-form">
                        <input type="radio" id="choice-1" name="R" value="1" checked/>
                        <label for="choice-1">1</label>
                        <input type="radio" id="choice-2" name="R" value="2"/>
                        <label for="choice-2">2</label>
                        <input type="radio" id="choice-3" name="R" value="3"/>
                        <label for="choice-3">3</label>
                        <input type="radio" id="choice-4" name="R" value="4"/>
                        <label for="choice-4">4</label>
                        <input type="radio" id="choice-5" name="R" value="5"/>
                        <label for="choice-5">5</label>
                    </div>
                </fieldset>
                <div class="xyR-form">
                    <button id="button-submit" type="submit">
                        SUBMIT
                    </button>
                </div>                
            </form>
        </div>
    </body>
</html>