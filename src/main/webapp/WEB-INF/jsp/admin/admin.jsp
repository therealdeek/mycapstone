<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

    <h1>Users</h1>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${users}" var="user" >
              <tr>
                <td>${users.id}</td>
                <td>${users.name}</td>
                <td>${users.email}</td>
                <td>
                  <a href="viewUser?id=${user.id}">View</a>
                  <a href="editUser?id=${user.id}">Edit</a>
                  <a href="deleteUser?id=${user.id}" onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>


 <jsp:include page="../include/footer.jsp" />
