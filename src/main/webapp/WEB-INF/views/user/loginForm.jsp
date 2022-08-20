<%@ include file="../layout/header.jsp" %>
<div class="container mt-3">
    <form>
        <div class="form-group">
            <label for="username" class="form-label">Username:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        </div>
        <div class="form-group">
            <label for="pwd" class="form-label">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
        </div>
        <div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox" name="remember"> Remember me
            </label>
        </div>
    </form>
    <button id="btn-login" class="btn btn-primary">login</button>
</div>
<script src="/blog/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>


