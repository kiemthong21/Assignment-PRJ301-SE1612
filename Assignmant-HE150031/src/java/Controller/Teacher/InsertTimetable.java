/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Teacher;

import DAL.ClassDB;
import DAL.ScheduleDB;
import Model.Account;
import Model.Classs;
import Model.Schedule;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class InsertTimetable extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassDB clDB = new ClassDB();
        int clssID = Integer.parseInt(request.getParameter("clssID"));
        Account account = (Account) request.getSession().getAttribute("account");
        ScheduleDB scheDB = new ScheduleDB();
        ArrayList<Schedule> scheduleUC = scheDB.getScheduleByTeacherandClass(account.getUserID(), clssID);
        request.setAttribute("scheduleUC", scheduleUC);
        request.getRequestDispatcher("view/teacher/InsertTimetable.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
