<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/17
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>欢迎页</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="https://v4.bootcss.com/docs/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="https://v4.bootcss.com/docs/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="https://v4.bootcss.com/docs/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
    <link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon.ico">
    <meta name="msapplication-config" content="/docs/assets/img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#563d7c">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    <style type="text/css">/* Chart.js */
    @-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style></head>
<body>
<!--上边的导航栏-->
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" ><td> <div style="color:white; align:center;">欢迎回来，<%=session.getAttribute("username")%></div> </td></a>

    </a>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="login.jsp">退出</a>
        </li>
    </ul>
</nav>
<!--左边的导航栏-->
<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="success.jsp">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
                            首页 <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <div id="accordion" class="panel-group">
                            <!-- 子模块的标题 -->
                            <a class="nav-link active" data-toggle="collapse" href="#collapseThree" data-parent="#accordion">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers"><polygon points="12 2 2 7 12 12 22 7 12 2"></polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
                                设备报修管理
                            </a>
                            <!--收缩div-->
                            <div id = "collapseThree" class="panel-collapse">
                                <div class="panel-body">
                                    <a class="dropdown-item" href="repairs.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        设备报修
                                    </a>
                                    <a class="dropdown-item" href="assign.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        报修分派
                                    </a>
                                    <a class="dropdown-item" href="maintain.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        维修管理
                                    </a>
                                    <a class="dropdown-item" href="equi_manag.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        设备管理
                                    </a>
                                    <a class="dropdown-item" href="area_manag.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        区域管理
                                    </a>
                                </div>
                            </div>
                            <a class="nav-link" data-toggle="collapse" href="#collapseThree2" data-parent="#accordion">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers"><polygon points="12 2 2 7 12 12 22 7 12 2"></polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
                                用户管理
                            </a>
                            <div id="collapseThree2" class="panel-collapse">
                                <div class="panel-body">
                                    <a class="dropdown-item" href="user.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        用户管理
                                    </a>
                                    <a class="dropdown-item active" href="role.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        角色管理
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        权限管理
                                    </a>
                                </div>
                            </div>
                        </div>
                    </li>

                </ul>
            </div>
        </nav>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">角色管理</h1>
            </div>
            <!--写一个table bootstrap-table-->
            <!-- toolbar  -->
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div id="toolbar" >
                        <form class="form-inline" style="width:100%; margin-bottom: 20px;">
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="新增角色" id="addBtn" data-toggle="modal" data-target="#addRoleModal" class="btn btn-primary" >
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="删除角色" id="deleteBtn" class="btn btn-info" onclick="deleteRole()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="修改角色" id="editBtn" class="btn btn-danger" onclick="editRole()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <label for="queryName"></label>
                                <input type="text" id="queryName" placeholder="角色名" class="form-control">
                                <input type="button" class="btn btn-success" id="queryBtn"  value="查询" onclick="queryRole()">
                            </div>
                        </form>

                    </div>
                    <div class="container" style="width:100%;margin-top: 20px;">
                        <!--放一个table元素-->
                        <table id="table"></table>
                    </div>
                </div>
            </div>

            <!-- 新增区域模态窗体 -->
            <div class="modal fade" id="addRoleModal" role="dialog" tabindex="-1">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header ">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="resetForm()"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">角色信息</h4>
                        </div>
                        <div class="modal-body">

                            <form id="addRoleForm" class="form-horizontal" action="role/add"  method="post">
                                <input type="hidden" name ="id" id="roleId">
                                <div class="form-group">
                                    <label for="role_name" class="col-sm-2 control-label">角色名：</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="role_name" id="role_name" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="floor" class="col-sm-2 control-label">权限：</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="floor" id="floor"  placeholder="权限未开通" class="form-control">
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="resetForm()">取消</button>
                            <button type="button" class="btn btn-primary" onclick="addRole()">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
<script src="js/jquery.min.js" ></script>
<script src="js/bootstrap.bundle.min.js"></script>
<%--<script src="jss/feather.min.js"></script>--%>
<%--<script src="jss/dashboard.js"></script>--%>
<!-- 引入 bootstrap-table js -->
<script type="text/javascript" src="bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<!--font awesome-->
<script src="https://cdn.bootcss.com/font-awesome/5.8.1/js/all.min.js"></script>
<script>
    $('#table').bootstrapTable({
        contentType:"application/x-www-form-urlencoded",
        url: '${pageContext.request.contextPath}/role/queryList',
        queryParams:queryParam,
        method:"POST",
        dataType:"json",
        pagination:true,
        sidePagination:"server",
        pageNumber:1,
        pageSize:5,
        pageList:[5,10,25],
        uniqueId:"id",
        striped:true,
        singleSelect:true,
        clickToSelect:true,
        showRefresh:true,
        showToggle:true,
        toolbar:"#toolbar",
        columns: [{
            field:"state",
            checkbox:"true"
        },{
            field: 'id',
            title: 'ID'
        }, {
            field: 'role_name',
            title: '角色名'
        }]
    });
    function queryParam(params){
        console.info(params);
        console.log(this);
        var param={
            queryName:$("#queryName").val(),
            limit:params.limit,
            offset:params.offset,
            pageIndex:this.pageNumber,
            pageSize:this.pageSize
        }
        console.info(param);
        return param;
    }
    //查询按钮操作
    function queryRole() {
        $('#table').bootstrapTable('refresh');
    }
    //新增区域信息
    function addRole() {
        var roleId=$('#roleId').val()

        var role_name=$('#role_name').val()
        var url=''
        if(roleId===''){
            url="${pageContext.request.contextPath}/role/add"
        }else{
            url='${pageContext.request.contextPath}/role/update'
        }
        $.ajax({
            url:url,
            data:{"id":roleId,"role_name":role_name},
            method:"post",
            dataType:"json",
            success:function (result) {
                if(result.status==="success"){
                    alert(result.message)
                    $('#addRoleModal').modal('hide');
                    resetForm()
                }else{
                    alert(result.message)
                }
            },
            timeout:1000,
            error:function (error) {
                alert("服务器请求失败！")
            }
        });
    }
    function resetForm() {
        $('#addRoleForm').find('input[type=text],input[type=hidden]').each(function () {
            $(this).val('')
        })
        $('#table').bootstrapTable('refresh');
    }
    function editRole() {
        var rows=$('#table').bootstrapTable('getSelections')
        if(rows.length===0){
            alert("请选择数据行")
            return;
        }
        var currentRow=rows[0]//把这个页面的id
        $('#roleId').val(currentRow.id)
        $('#role_name').val(currentRow.role_name)
        //显示模态框
        $('#addRoleModal').modal('show');
    }
    function deleteRole() {
        var rows=$('#table').bootstrapTable('getSelections')
        if(rows.length===0){
            alert("请选择数据行")
            return;
        }
        var answer=window.confirm("确定要删除这行数据吗？");
        if(!answer){
            return;
        }
        var currentRow=rows[0]
        var areId=currentRow.id;
        $.ajax({
            url:"${pageContext.request.contextPath}/role/delete",
            method:"post",
            data:{"id":areId},
            dataType:"json",
            success:function(result){
                $('#table').bootstrapTable('refresh');
            },
            timeout:1000,
            error:function (error) {
                alert(error)
            }
        })
    }
</script>
</body></html>