package cn.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.FormSubmitEvent;

import cn.domain.User;
import cn.exception.ServiceUserExist;
import cn.service.impl.BusinessServiceImpl;
import cn.utils.WebUtils;
import cn.web.formbean.RegisterForm;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RegisterForm form = WebUtils.reuqest2Bean(request, RegisterForm.class);
		form.setServer_checkcode((String) request.getSession().getAttribute("checkcode"));
		boolean b = form.validate();
		if(!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());
		BusinessServiceImpl service = new BusinessServiceImpl();
		try {
			service.register(user);
			request.setAttribute("message", "注册成功！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		} catch (ServiceUserExist e) {
			form.getErrors().put("username", "用户名已存在！！！");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch(Exception e1) {
			e1.printStackTrace();
			request.setAttribute("message", "未知错误！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
