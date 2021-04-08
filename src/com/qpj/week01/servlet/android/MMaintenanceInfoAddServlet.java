package com.qpj.week01.servlet.android;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.been.JsonData;
import com.qpj.week01.been.RepairInfoVo;
import com.qpj.week01.been.UserInfo;
import com.qpj.week01.dao.RepairDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MMaintenanceInfoAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //获取要上传文件到的路径
        String path = req.getRealPath("/upload");
        //如果无以下设置，上传大文件会占用内存
        //设置暂时存放的存储文件夹。此文件夹与想要存到的最终文件夹不同
        /*
         * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
         * 格式的 然后再将其真正写到 对应目录的硬盘上
         */
        factory.setRepository(new File(path));
        //设置缓存的大小，当上传文件的容量超过该缓存时，放在临时文件夹
        factory.setSizeThreshold(1024 * 1024);
        //API文件上传处理
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //可以同时上传多个文件
            List<FileItem> list = (List<FileItem>)upload.parseRequest(req);
            for (FileItem item : list){
                //获取用户具体输入的字符串，表单提交过来时是字符串类型的
                String name = item.getFieldName();
                if(item.isFormField()) {
                    String value = item.getString();
                    req.setAttribute(name,value);
                }else {//对传入的非简单字符串进行处理
                    /*获取上传文件的名字*/
                    //获取路径名
                    String value = item.getName();
                    //索引到最后一个反斜杠
                    int start = value.lastIndexOf("\\");
                    //截取上传文件的字符串名字，加1去掉反斜杠
                    String filename = value.substring(start + 1);

                    String rootDir = req.getRealPath("/");
                    String relaDir = File.separator + "upload";

                    //文件夹不存在则创建
                    File fdir = new File(rootDir + relaDir);
                    if(!fdir.exists()){
                        fdir.mkdirs();
                    }
                    req.setAttribute(name,"/" + "upload" + "/" + filename);
                    //真正的写到磁盘上
                    File file = new File(path,filename);
                    OutputStream outputStream = new FileOutputStream(file);
                    InputStream in = item.getInputStream();
                    int length = 0;
                    byte[] buf = new byte[1024];
                    while ((length=in.read(buf))!=-1){
                        outputStream.write(buf,0,length);
                    }
                    in.close();
                    outputStream.close();
                }
            }
            out.println("文件上传成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        String maintenanceSN = req.getAttribute("maintenanceSN").toString();
        maintenanceSN = new String(maintenanceSN.getBytes("ISO-8859-1"),"UTF-8");
        String areaID = req.getAttribute("areaID").toString();
        areaID = new String(areaID.getBytes("ISO-8859-1"),"UTF-8");
        String equipmentID = req.getAttribute("equipmentID").toString();
        equipmentID = new String(equipmentID.getBytes("ISO-8859-1"),"UTF-8");
        String location = req.getAttribute("location").toString();
        location = new String(location.getBytes("ISO-8859-1"),"UTF-8");
        String image = req.getAttribute("image").toString();
        image = "/week" + new String(image.getBytes("ISO-8859-1"),"UTF-8");
        String remark = req.getAttribute("description").toString();
        remark = new String(remark.getBytes("ISO-8859-1"),"UTF-8");
        UserInfo loginUserInfo = (UserInfo)req.getSession().getAttribute("_m_userInfo");
        int loginUserId = loginUserInfo.getId();
        RepairInfoVo repairInfoVo = new RepairInfoVo();
        repairInfoVo.setMaintenanceSN(maintenanceSN);
        repairInfoVo.setAreaID(Integer.parseInt(areaID));
        repairInfoVo.setEquipmentID(Integer.parseInt(equipmentID));
        repairInfoVo.setLocation(location);
        repairInfoVo.setImageURL(image);
        repairInfoVo.setReportContent(remark);
        repairInfoVo.setReportUserID(loginUserId);

        RepairDao repairDao = new RepairDao();
        try {
            boolean insert = repairDao.insert(repairInfoVo);
            JSONObject result = new JSONObject();
            JsonData<RepairInfoVo> jsonData = new JsonData<>();
            if(insert){
                jsonData.setCode(0);
                jsonData.setMsg("保存成功");
                jsonData.setData(repairInfoVo);
            }else {
                jsonData.setCode(-1);
                jsonData.setMsg("保存失败");
            }
            resp.getWriter().println(JSON.toJSONString(jsonData));
            resp.getWriter().flush();
            resp.getWriter().close();
            repairDao.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
