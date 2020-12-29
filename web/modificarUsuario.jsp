<%-- 
    Document   : index
    Created on : 17 dic. 2020, 23:03:40
    Author     : Gian
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Empleado"%>
<%@page import="Logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%                                         Controladora control = new Controladora();
                                        List<Empleado> listaEmpleados = control.getListaEmpleados();
                                        List<Usuario> listaUsuarios = control.getListUsuarios(); 
                                      
                                        
         
                                        
%>
<!DOCTYPE html>
<html lang="es">
    <%
    
     HttpSession misesion = request.getSession();
    
    String usuario = (String) request.getSession().getAttribute("usuario");
    String nombre = (String) request.getSession().getAttribute("nombre");
    String apellido = (String) request.getSession().getAttribute("apellido");

    if (usuario == null){
        response.sendRedirect("login.jsp");
    } 
    

    //completo campos
    
        
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        Usuario user = new Usuario();
        user = control.getUsuarioXid(idUsuario);
        
       
    %>
    
    
<head>
    

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Parque de diversiones</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-briefcase"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Backoffice</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Tablero</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Menú
            </div>
                        <li class="nav-item">
                <a class="nav-link" href="empleados.jsp">
                    <i class="fas fa-user-friends"></i>
                    <span>Empleados</span>
                </a>
            </li>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link" href="usuarios.jsp">
                    <i class="fas fa-users"></i>
                    <span>Usuarios</span>
                </a>
            </li>


            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="juegos.jsp">
                    <i class="fas fa-dice-six"></i>
                    <span>Juegos</span>
                </a>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="entradas.jsp">
                    <i class="fas fa-ticket-alt"></i>
                    <span>Entradas</span>
                </a>
            </li>


            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="cupos.jsp">
                    <i class="fas fa-calendar-alt"></i>
                    <span>Cupos</span>
                </a>
            </li>

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            <!-- Sidebar Message -->

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light topbar mb-4 static-top">
                    <h1 class="h3 mb-0 text-gray-800">Usuarios</h1>
                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search 
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                -->

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>






                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <span class="nav-link">
                                <i class="fas fa-users"> &nbsp; </i>
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=nombre+" "+apellido%></span>
                                <div class="topbar-divider d-none d-sm-block"></div>
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><a href="logout.jsp">Cerrar Sesión</a></span>
                            </span>


                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->

                    <!-- Content Row -->
                    <div class="row">


                        <!-- Earnings (Monthly) Card Example -->
                        

                    <!-- Content Row -->


             


                    <!-- Content Row -->


                        <!-- Content Column -->
  
                            <div class="col-lg-12">
                                <h3>Modificar Usuario</h3>
                                <hr>
                            </div>
                        
                          <div class="col-lg-12">
                              
                              
                              

                              <form action="ServletModificarUsuario?id=<%=user.getIdUsuario()%>" method="POST">
                                  <div class="form-group">
                                      <label>Nombre de usuario</label>
                                      <input type="text" class="form-control" name="usuario" value ="<%=user.getUsuario()%>"Ingrese el nombre de usuario" data-validate = "Ingrese nombre de usuario" required>
                                  </div>
                                  <div class="form-group">
                                      <label>Contraseña</label>
                                      <input type="text" class="form-control" name="password" value="<%=user.getPassword()%>" placeholder="Ingrese la contraseña" data-validate = "Ingrese la password" required>
                                  </div>
                                  <div class="form-group">
                                      <label>Email</label>
                                      <input type="email" class="form-control" name="email" value="<%=user.getEmail() %>"placeholder="Ingrese el email" data-validate = "Ingrese el email" required>
                                  </div>
                                  <div class="form-group">
                                      <label>Seleccione el empleado asociado al usuario</label>
                                      
          
                                      <select class="form-control" name="empleado" required>
                                          <%  
                  
                                              
                                              for (Empleado emple:listaEmpleados){
                                                
                                          %>
                                          <option value="<%=emple.getIdEmpleado() %>"><%=emple.getIdEmpleado() + " - " + emple.getNombre() + " " + emple.getApellido() + " - DNI " + emple.getDni() %></option>
                                      <% } %>
                                      </select>
                                     
                                  </div>
                                  <div class="form-check">
                                      <input class="form-check-input" name="administrador" type="checkbox" <%if (user.isEsAdministrador()){ %>checked<% }%>>
                                      <label class="form-check-label" >
                                          Marcar para hacerlo administrador
                                      </label>
                                  </div>
                                  <div class="container-login100-form-btn">
                                      <button class="btn btn-success btn-icon-split" type="submit">
                                          <span class="text">Modificar usuario</span>
                                      </button>
                                  </div>
                              </form>


                        
                
                            
                           
                            
                         

                        </div>


      <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer ">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Parque de diversiones - 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

 
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>