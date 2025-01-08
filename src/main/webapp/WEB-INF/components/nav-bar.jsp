<nav class="navbar navbar-expand-lg navbar-dark primary-background">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp"><span class="fa fa-diamond"></span> KnowledgeMD</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="https://www.github.com/Geez14"><span class="fa fa-github-alt"></span>
                        Code&Whiskers</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <span class="fa fa-book"></span> Categories
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">LeetCode</a></li>
                        <li><a class="dropdown-item" href="#">DSA</a></li>
                        <li><a class="dropdown-item" href="#">AI/ML</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">News</a></li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#"><span class="fa fa-address-book-o"></span> Contact</a>
                </li>
                <% if (session.getAttribute("userSession") == null) {
                %>
                }
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp"><span class="fa fa-user-circle"></span> Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp"><span class="fa fa-user-plus"></span> SignUp/Register</a>
                </li>
                <% } else {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="profile.jsp"><span class="fa fa-user-circle-o"></span> Profile</a>
                </li>
                <%}%>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>