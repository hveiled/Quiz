# Quiz
_tech issue for junior java dev by Akvelon: REST service_

<h3>Application has four endpoints:</h3>
<hr>
<h5>POST /api/quiz/new</h5> 
<p>receiving request body of a new Quiz object</p>
<p>RETURNING VALUE: "id":value</p>
<p>Response code: 200 (OK)</p>
<hr>
<h5>DELETE /api/quiz/delete</h5>
<p>receiving id of a Quiz object</p>
<p>Response code: 403 (NOT_FOUND)</p>
<hr>
<h5>PUT /api/quiz/{id}</h5>
<ul><b>receiving values:</b>
    <li>id of a Quiz object</li>
    <li>new Quiz object</li>
</ul>
<p>RETURNING VALUE: "id":value</p>
<p>Response code: 200 (OK)</p>
<hr>
<h5>GET /api/quiz</h5>
<ul><b>not required request parameters:</b>
    <li>quiz name</li>
    <li>quiz start date</li>
    <li>quiz either active or not </li>
</ul>
<ul><b>required request parameters:</b>
    <li>sort by date or sort by start date</li>
</ul>
<p>RETURNING VALUE: List of Quiz objects</p>
<p>Response code: 200 (OK)</p>
<hr>
<h4>Swagger documentation:</h4>
http://localhost:8080/swagger-ui.html



