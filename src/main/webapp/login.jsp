<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <%-- css --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="resources/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%-- navbar --%>
<%@ include file="WEB-INF/components/nav-bar.jsp" %>
<%-- form-control --%>
<main class="d-flex align-items-center primary-background banner-background" style="height: 80dvh">
    <div class="container">
        <%-- This row can contain 12 columns --%>
        <div class="row">
            <%-- column occupy 4 column space where we give offset of 4 column --%>
            <div class="col-md-4 offset-md-4" style="min-width: 300px">
                <div class="card">
                    <div class="card-header primary-background text-white">
                        <div style="width: 100%;text-align: center">
                            <span class="fa fa-user-circle fa-3x"></span>
                            <br/>
                            <p>Login Form</p>
                        </div>
                    </div>
                    <div class="card-body">
                        <form id="user-login-form" action="${pageContext.request.contextPath}/login" method="POST">
                            <%-- email --%>
                            <div class="mb-3">
                                <label for="user-email" class="form-label">Email address</label>
                                <input type="email" class="form-control" name="email" id="user-email"
                                       placeholder="Enter email"
                                       aria-describedby="emailHelp" required>
                            </div>

                            <%-- password --%>
                            <div class="mb-3">
                                <label for="user-password" class="form-label">Password</label>
                                <input type="password" class="form-control" name="password" id="user-password"
                                       placeholder="Enter password" required>
                            </div>

                            <%-- remeber me --%>
                            <div class="mb-3 form-check">
                                <input type="checkbox" class="form-check-input" name="check" id="remember-me">
                                <label class="form-check-label" for="remember-me">Remember me</label>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%-- javascript --%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
<%-- for animated alerts --%>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<%@include file="WEB-INF/components/footer.jsp"%>
<script>
    $(document).ready(() => {
        console.log("Form loaded")
        $("#user-login-form").on("submit", (event) => {
            event.preventDefault();
            let form = new FormData(event.target);
            $.ajax({
                url: "login",
                type: "POST",
                data: form,
                success: (data, textStatus, jqXHR) => {
                    Swal.fire({
                        icon: "success",
                        title: "Success",
                        text: data.responseText,
                    });
                },
                error: (data, textStatus, errorThrown) => {
                    Swal.fire({
                        icon: "error",
                        title: "Error",
                        text: data.responseText,
                    });
                },
                processData: false,
                contentType: false
            })
        });
    });
</script>
</body>
</html>
