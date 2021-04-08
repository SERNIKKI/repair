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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>用户管理</title>

    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    <style type="text/css">/* Chart.js */
    @-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style>

    <!-- font awesome css-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

    <!-- boostrap-table css-->
    <link href="bootstrap-table/bootstrap-table.min.css">
</head>
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
                                    <a class="dropdown-item active" href="user.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        用户管理
                                    </a>
                                    <a class="dropdown-item" href="role.jsp">
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
        <!-- 右边的主体部分 -->
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">用户管理</h1>
            </div>
            <!--写一个table bootstrap-table-->
            <!-- toolbar  -->
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div id="toolbar" >
                        <form class="form-inline" style="width:100%; margin-bottom: 20px;">
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="新增用户" id="addBtn" data-toggle="modal" data-target="#addUserModal" class="btn btn-primary" onclick="initModalPage()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="删除用户" id="deleteBtn" class="btn btn-info" onclick="deleteArea()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="修改用户" id="editBtn" class="btn btn-danger" onclick="editArea()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <label for="queryName"></label>
                                <input type="text" id="queryName" class="form-control">
                                <input type="button" class="btn btn-success" id="queryBtn"  value="查询" onclick="queryArea()">
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
            <div class="modal fade" id="addUserModal" role="dialog" tabindex="-1">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header ">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="resetForm()"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">用户信息</h4>
                        </div>
                        <div class="modal-body">

                            <form id="addAreaForm" class="form-horizontal" action="user/add"  method="post">
                                <input type="hidden" name ="id" id="userId">
                                <div class="form-group">
                                    <label for="user_name" class="col-sm-2 control-label">名称：</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="user_name" id="user_name" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="user_password" class="col-sm-2 control-label">密码：</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="user_password" id="user_password" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="role_name"class="col-sm-10">角色: </label>
                                    <select id="role_name" name="role_name"style="width: 300px;height: 45px">
                                        <option disabled selected>---请选择角色---</option>
                                    </select>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="resetForm()">取消</button>
                            <button type="button" class="btn btn-primary" onclick="addArea()">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>

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
    <script type="text/javascript">
        function paramsMatter(value,row,index,field){
            var span=document.createElement('span');
            span.setAttribute('title',value);
            span.innerText=value;
            return span.outerHTML;
        }
        function formatTableUnit(value,row,index){
            return {
                css:{
                    "white-space":'nowrap',
                    "text-overflow":'ellipsis',
                    "overflow":'hidden',
                    "max-width":"150px"
                }
            }
        }

        function initModalPage(){
            $.ajax({
                url: "${pageContext.request.contextPath}/role/nameList",
                method: "post",
                success: function( result ) {
                    console.log(result);
                    var r = result;

                    if(result.rolename !=null){
                        console.log(result.rolename);
                        var rolename = result.rolename;
                        if(rolename.length!==0){
                            $("#role_name").empty()
                                .append("<option disabled selected>---请选择角色---</option>");
                        }
                        for (var i = 0; i < rolename.length; i++) {
                            $("#role_name")
                                .append(("<option value='" + rolename[i] + "'>" + rolename[i] + "</option>"));
                        }
                    }
                },
                error: function (error) {
                    console.log(error);
                }
            });
            console.log("ka")
            $("#addUserModal").modal("show");

        }
    </script>
    <script>
        $('#table').bootstrapTable({
            contentType:"application/x-www-form-urlencoded",
            url: '${pageContext.request.contextPath}/user/queryList',
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
                field: 'user_name',
                title: '用户名'
            }, {
                field: 'user_password',
                title: '密码'
            },{
                field: 'role_name',
                title: '角色'
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
        function queryArea() {
            $('#table').bootstrapTable('refresh');
        }
        //新增区域信息
        function addArea() {
            var id=$('#userId').val()
            var user_name=$('#user_name').val()
            var user_password=$('#user_password').val()
            var role_name = $('#role_name').val()
            var url=''
            if(id===''){
                url="${pageContext.request.contextPath}/user/add"
            }else{
                url='${pageContext.request.contextPath}/user/update'
            }
            $.ajax({
                url:url,
                data:{"id":id,"user_name":user_name,"user_password":user_password,"role_name":role_name},
                method:"post",
                dataType:"json",
                success:function (result) {
                    if(result.status==="success"){
                        alert(result.message)
                        $('#addUserModal').modal('hide');
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
            $('#addAreaForm').find('input[type=text],input[type=hidden]').each(function () {
                $(this).val('')
            })
            $('#table').bootstrapTable('refresh');
        }
        function editArea() {
            initModalPage();
            var rows=$('#table').bootstrapTable('getSelections')
            if(rows.length==0){
                alert("请选择数据行")
                return;
            }
            var currentRow=rows[0]//把这个页面的id
            $('#userId').val(currentRow.id)
            $('#user_name').val(currentRow.user_name)
            $('#user_password').val(currentRow.user_password)
            //显示模态框
            $('#addUserModal').modal('show');
        }
        function deleteArea() {
            var rows=$('#table').bootstrapTable('getSelections')
            if(rows.length==0){
                alert("请选择数据行")
                return;
            }
            var answer=window.confirm("确定要删除这行数据吗？");
            if(!answer){
                return;
            }
            var currentRow=rows[0]
            var userId=currentRow.id;
            $.ajax({
                url:"${pageContext.request.contextPath}/user/delete",
                method:"post",
                data:{"id":userId},
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
