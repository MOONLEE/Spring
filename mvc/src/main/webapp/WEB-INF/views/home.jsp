<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<!doctype html>
<html ng-app="todoApp">
  <head>
     <style type="text/css">
.slash {
	background-image: url(/spring/images/slash.png);
	background-size: 100% 100%;
	text-align: left;
}
.backslash {
	background-image: url(/spring/images/backslash.png);
	background-size: 100% 100%;
	text-align: left;
}
.slash div, .backslash div { text-align: right; }
table {
	border-collapse: collapse;
	border-top: 1px solid gray;
	border-left: 1px solid gray;
}  
th, td {
	border-bottom: 1px solid gray;
	border-right: 1px solid gray;
	padding: 5px;
}
</style>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
    <script src="todo.js"></script>
    <link rel="stylesheet" href="todo.css">
  </head>
  <body>
    <h2>Todo</h2>
    <div ng-controller="TodoListController as todoList">
      <span>{{todoList.remaining()}} of {{todoList.todos.length}} remaining</span>
      [ <a href="" ng-click="todoList.archive()">archive</a> ]
      <ul class="unstyled">
        <li ng-repeat="todo in todoList.todos">
          <label class="checkbox">
            <input type="checkbox" ng-model="todo.done">
            <span class="done-{{todo.done}}">{{todo.text}}</span>
          </label>
        </li>
      </ul>
      <form ng-submit="todoList.addTodo()">
        <input type="text" ng-model="todoList.todoText"  size="30"
               placeholder="add new todo here">
        <input class="btn-primary" type="submit" value="add">
      </form>
    </div>
    
 <table>
<tr>
	<th class='backslash' style='width:60px'><div>요일</div>교시</th>
	<th>월</th>
	<th>화</th>
	<th>수</th>
	<th>목</th>
</tr>
<tr>
	<td>1</td>
	<td>국어</td>
	<td>영어</td>
	<td>수학</td>
	<td>미술</td>
</tr>
<tr>
	<td>2</td>
	<td>사회</td>
	<td>체육</td>
	<td>국사</td>
	<td class='slash'>H<div>R</div></td>
</tr>
</table>
  </body>
</html>
