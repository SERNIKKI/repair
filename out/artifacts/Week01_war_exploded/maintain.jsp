<%--
  Created by IntelliJ IDEA.
  User: 18239
  Date: 2020/6/2
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>设备管理页面</title>

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
                                    <a class="dropdown-item active" href="maintain.jsp">
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
                                系统管理
                            </a>
                            <div id="collapseThree2" class="panel-collapse">
                                <div class="panel-body">
                                    <a class="dropdown-item" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        个人中心
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        系统管理2
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        系统管理3
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        系统管理4
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
                <h1 class="h2">维修管理</h1>
            </div>
            <!--写一个table bootstrap-table-->
            <!-- toolbar  -->
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div id="toolbar" >
                        <form class="form-inline" style="width:100%; margin-bottom: 20px;">
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="完成维修" id="addBtn" data-toggle="modal" data-target="#addMaintenanceModal" class="btn btn-primary" >
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <label for="queryEquName"></label>
                                <input type="text" id="queryEquName" class="form-control" placeholder="设备名称">
                                <div class="form-group">
                                    <label class="btn btn-secondary">状态</label>
                                    <select class="form-control" id = "queryMainStatus" name="queryMainStatus">
                                        <option disabled selected>---请选择---</option>
                                        <option value="0">新报修</option>
                                        <option value="1">维修中</option>
                                        <option value="2">已完成</option>
                                    </select>
                                </div>
                                <input type="button" class="btn btn-success" id="queryBtn"  value="查询" onclick="queryEquipment()">
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
            <div class="modal fade" id="addMaintenanceModal" role="dialog" tabindex="-1" aria-labelledby="addMaintenanceModal">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header ">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="resetForm()"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">状态设置</h4>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name ="id" id="id">
                            <tbody>
                            <td>维修描述</td>
                            <td>
                                <input type="text" name="mainContent" id="mainContent" class= "form- control" style="width: 470px;height: 42px">
                            </td>
                            <td>选择状态</td>
                            <td>
                                <select class="form-control" id = "MainStatus" name="MainStatus" style="width: 470px;height: 42px">
                                    <option disabled selected>---请选择---</option>
                                    <option value="0">报修</option>
                                    <option value="1">受理</option>
                                    <option value="2">完成</option>
                                </select>
                            </td>
                            <%--                            <div style="padding-top: 20px"></div>--%>
                            </tbody>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                            <button type="button" id="addSaveBtn"onclick="addMaintenance()" class="btn btn-primary" data-dismiss="modal">
                                <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>确认</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>

    </div>
    <script src="js/jquery.min.js" ></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="./ajaxupload/ajaxfileupload.js"></script>
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
    </script>
    <script>
        /*当页面加载完成后，立刻执行这个函数*/
        $(function(){

            initTable();

        });
        function initTable(){
            //用于将table销毁，如果不用【则会保留上次加载的内容】
            $("#table").bootstrapTable('destroy');
            $("#table").bootstrapTable({
                method:"POST",
                contentType : "application/x-www-form-urlencoded",
                dataType:"json",
                url:"${pageContext.request.contextPath}/maintain/list",
                queryParams:queryParam,
                striped: true,
                pagination:true,
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pageSize: 5,                       //每页的记录行数（*）
                pageList: [5, 10, 25],        //可供选择的每页的行数（*）
                uniqueId: "id",
                sidePagination: "server", 			//server表示服务端分页，client客户端分页
                singleSelect:true,
                clickToSelect:true,
                showRefresh:true,
                showToggle:true,
                toolbar:"#toolbar",
                columns:[{
                    field:"state",
                    checkbox:"true"
                },{
                    field:"id",
                    title:"ID",
                }, {
                    field: 'maintenanceSN',
                    title: '报修单号'
                }, {
                    field: 'areaID',
                    title: '区域ID',
                    visible: false
                },{
                    field: 'building',
                    title: '楼栋'
                }, {
                    field: 'floor',
                    title: '楼层'
                }, {
                    field: 'equipmentID',
                    title: '设备ID',
                    visible: false
                },{
                    field: 'equ_name',
                    title: '设备名称'
                },{
                    field: 'equipmentType',
                    title: '设备类型',
                    visible: false
                }, {
                    field: 'reportUserID',
                    title: '报修人ID',
                    visible: false
                }, {
                    field: 'user_name',
                    title: '报修人',
                    visible: false
                }, {
                    field: 'reportContent',
                    title: '备注',
                    cellStyle:formatTableUnit,
                    formatter :paramsMatter
                }, {
                    field: 'imageURL',
                    title: '图片',
                    detailView : true,
                    formatter : function (value,row,index) {
                        if(value!==''){
                            console.log(row);
                            var image = '<div class="photos">'
                                + '<a target="_blank" href="' + row['imageURL'] + '">'
                                +'<img alt="image" style="width: 120px;height: 50px;margin: auto" class="feed-photo"'
                                + ' src="' + row['imageURL'] + '"></a>'
                                + '</div>';
                            return image;
                        }else{
                            return '';
                        }

                    },
                    align: 'center'

                }, {
                    field: 'location',
                    title: '具体位置',
                }, {
                    field: 'status',
                    title: '状态',
                    formatter : function (value, row, index) {
                        console.log(row);
                        if (row['status'] === 0) {
                            return '报修';
                        }
                        if (row['status'] === 1) {
                            return '受理';
                        }
                        if (row['status'] === 2) {
                            return '完成';
                        }
                        return value;
                    },
                    align: 'center'
                }, {
                    field: 'startTime',
                    title: '报修时间'
                },{
                    field: "maintenanceContent",
                    title: "报修备注",
                },{
                    field: "endTime",
                    title: "完成时间"
                }],
            });
        }
        function queryParam(params){
            // console.info(params);
            // console.log(this);
            var param={
                equipmentName:$("#queryEquName").val(),
                status:$("#queryMainStatus").val(),
                limit:params.limit,
                offset:params.offset,
                pageIndex:this.pageNumber,
                pageSize:this.pageSize
            }
            // console.info(param);
            return param;
        }

        //查询按钮操作
        function queryEquipment() {
            $('#table').bootstrapTable('refresh');
        }
        //新增区域信息
        function addMaintenance() {
            var param=$("#addMaintenanceModal").serializeArray();

            var mainContent = $('#mainContent').val()
            var mainStatus = $('#MainStatus').val()
            // param.push({"name":"image","value":$("#image").attr("src")});
            // console.info(param);
            var rows = $('#table').bootstrapTable('getSelections')
            if(rows.length===0){
                alert("错误！请选择行")
                return;
            } else if(rows.length!==0){
                var currentRow = rows[0]
                var repID = currentRow.id;
                $('#id').val(repID);
            }
            var id=$("#id").val();
            var url='${pageContext.request.contextPath}/maintain/finish'
            $.ajax({
                url:url,
                data:{"mainContent":mainContent,"mainStatus":mainStatus,"id":id},
                method:"post",
                dataType:"json",
                success:function (result) {
                    if(result.status==="success"){
                        alert(result.message)
                        $('#addMaintenanceModal').modal('hide');
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
    </script>
    <script>
        <%--    图片上传--%>
        function upload_cover(obj) {
            // 调用 另外一个函数，请求ajax成功后，的一个匿名回调函数
            ajax_upload(obj.id, function (data) {
                //function(data)是上传图片的成功后的回调方法
                console.log("回调函数");
                console.log(data);
                var basePath = '${pageContext.request.contextPath }';
                console.log(basePath);
                //获取的图片的绝对路径
                var isrc = data.relatPath.replace(/\/\//g, '/');
                console.log(isrc);
                var imgSrc = basePath + isrc;
                console.log(imgSrc);
                //给<input>的src赋值去显示图片
                $('#image').attr('src', basePath + isrc).data('img-src', isrc);
            });
        }
        function ajax_upload(feid, callback) { //具体的上传图片方法
            if (image_check(feid)) { //自己添加的文件后缀名的验证
                console.log(feid);
                $.ajaxFileUpload({
                    fileElementId: feid,    //需要上传的文件域的ID，即<input type="file">的ID。
                    url: '${pageContext.request.contextPath}/repair/upload', //后台方法的路径
                    type: 'post',   //当要提交自定义参数时，这个参数要设置成post
                    dataType: 'json',   //服务器返回的数据类型。可以为xml,script,json,html。如果不填写，jQuery会自动判断。
                    secureuri: false,   //是否启用安全提交，默认为false。
                    async : true,   //是否是异步
                    success: function(data) {   //提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
                        console.log("函数是否执行成功")
                        if (callback) callback.call(this, data);
                    },
                    error: function(data, status, e) {  //提交失败自动执行的处理函数。
                        console.error(e);
                    }
                });
            }
        }
        function image_check(feid) { //自己添加的文件后缀名的验证
            var img = document.getElementById(feid);
            return /.(jpg|png|gif|bmp)$/.test(img.value)?true:(function() {
                alert('图片格式仅支持jpg、png、gif、bmp格式，且区分大小写。');
                return false;
            })();
        }
    </script>
</body></html>