package GroupA;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybeans.ScheduleDBBean;

public class Group_a extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException
	{

		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String schedule = request.getParameter("schedule");

		try {
				//Beanの作成
				ScheduleDBBean sb = new ScheduleDBBean();
				sb.setName(name);
				sb.setDate(date);
				sb.setSchedule(schedule);
				sb.insertdata();

				//サーブレットコンテキストの取得
				ServletContext sc = getServletContext();


				//リクエストに設定
				request.setAttribute("sb", sb);

				//リクエストの転送
				sc.getRequestDispatcher("/calender.jsp")
				.forward(request,  response);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

