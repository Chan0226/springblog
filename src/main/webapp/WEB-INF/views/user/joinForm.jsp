<%@ include file="../layout/header.jsp" %>
<div class="container mt-3">
    <form action="/user/join" method="POST">
        <div class="form-group">
            <label for="username" class="form-label">Username:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        </div>
        <div class="form-group">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="pswd">
        </div>
        <div class="form-group">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
        </div>
    </form>
    <button id="btn-save" class="btn btn-primary">Submit</button>
</div>
<%-- /js : static/js--%>
<script src="/blog/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>


