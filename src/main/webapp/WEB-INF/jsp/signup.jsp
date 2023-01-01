<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
    <style>
        li {
            float: left;
        }
        /* Add a black background color to the top navigation */
        .topnav {
            background-color: #333;
            overflow: hidden;
        }

        /* Style the links inside the navigation bar */
        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        /* Change the color of links on hover */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Add a color to the active/current link */
        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }

        ul
        {
            list-style-type: none;
            /*margin: 0;*/
            padding: 0;
            overflow: hidden;
            max-width: 310px;
            text-align: center;
            margin-left: 38%;
        }

        body {
            font-family: verdana;
        }
    </style>
</head>

<body>
<header>
    <nav>
        <ul>
            <div align="center" class="topnav">
                <li><a href="/login">Log In</a></li>
                <li><a href="/signup">Sign Up</a></li>
                <li><a href="/contact-us">Contact Us</a></li>
            </div>
        </ul>
    </nav>
</header>
<%-- div is for grouping items --%>
<div align="center">
    <br>
    Sign Up
    <br>
</div>
<div align="center">
    <form method="post" action="/signup">
        <div>
            <label>Username</label>
            <input type="text" name="username">
        </div>
        <div>
            <label>Password</label>
            <input type="password" name="password">
        </div>
        <div>
            <label>First Name</label>
            <input type="text" name="firstName">
        </div>
        <div>
            <label>Last Name</label>
            <input type="text" name="lastName">
        </div>
        <div>
            <label>Phone Number</label>
            <input type="number" name="phoneNumber">
        </div>
        <div>
            <label>Email</label>
            <input type="email" name="email">
        </div>
        <div>
            <label>Address</label>
            <input type="text" name="address">
        </div>
        <button type="submit">Sign Up</button>
    </form>
</div>
<div align="center">
    <br>
    Already have an account?
    <a href="/login">Log In</a>
    <br>
</div>
</body>

</html>
