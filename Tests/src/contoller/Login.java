package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // @Controller ����Java����controller���Ʋ�
public class Login {

    /**
     * @RequestParamע��������ǣ����ݲ�������URL��ȡ�ò���ֵ
     * @param username
     *            �û�����һ��Ҫ��Ӧ�ű���name����
     * @param password
     *            �û����룬ҲӦ�ö�Ӧ����������
     * @param model
     *            һ������󣬿����ڴ洢����ֵ
     * @return
     */
    @RequestMapping("/login") // @RequestMapping ע�������ָ����URL·�����ʱ����Ʋ�
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
            Model model) {

        if (username.equals("admin") && password.equals("admin")) {
            model.addAttribute("username", username);
            return "LoginOK";
        } else {
            model.addAttribute("username", username);
            return "LoginNG";
        }
    }

}
