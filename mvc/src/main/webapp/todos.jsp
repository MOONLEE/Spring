<!DOCTYPE html>
<!-- saved from url=(0053)http://localhost:9090/todos/examples/todos/index.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <title>Backbone.js Todos</title>
  <link rel="stylesheet" href="./css/todos.css">
</head>

<body>

  <div id="todoapp">

    <header>
      <h1>Todos</h1>
      <input id="new-todo" type="text" placeholder="What needs to be done?">
    </header>

    <section id="main" style="display: none;">
      <input id="toggle-all" type="checkbox">
      <label for="toggle-all">Mark all as complete</label>
      <ul id="todo-list"></ul>
    </section>

    <footer style="display: none;">
      <a id="clear-completed">Clear completed</a>
      <div id="todo-count"></div>
    </footer>

  </div>

  <div id="instructions">
    Double-click to edit a todo.
  </div>

  <div id="credits">
    Created by
    <br>
    <a href="http://jgn.me/">Jérôme Gravel-Niquet</a>.
    <br>Rewritten by: <a href="https://github.com/tastejs/todomvc">TodoMVC</a>.
  </div>

  <script src="./js/vendor/json2.js"></script>
  <script src="./js/vendor/jquery.js"></script>
  <script src="./js/vendor/underscore.js"></script>
  <script src="./js/backbone.js"></script>
  <script src="./js/examples/backbone.localStorage.js"></script>
  <script src="./js/todos.js"></script>

  <!-- Templates -->

  <script type="text/template" id="item-template">
    <div class="view">
      <input class="toggle" type="checkbox" {{ done ? 'checked="checked"' : '' }} />
      <label>{{- title }}</label>
      <a class="destroy"></a>
    </div>
    <input class="edit" type="text" value="{{ title }}" />
  </script>

  <script type="text/template" id="stats-template">
    {{ if (done) { }}
      <a id="clear-completed">Clear {{ done }} completed {{ done == 1 ? 'item' : 'items' }}</a>
    {{ } }}
    <div class="todo-count"><b>{{ remaining }}</b> {{ remaining == 1 ? 'item' : 'items' }} left</div>
  </script>

  

</body></html>