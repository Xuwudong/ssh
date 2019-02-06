package com.xwd.ssh.contorller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xwd.ssh.entity.Person;
import com.xwd.ssh.service.PersonService;



/**
 * controller
 * @author //��ʶ����һ��������
 * @Date2016��12��9������11:25:40
 */
@SessionAttributes(value = "username")
@Controller    //ʹ�ø�ע���־����һ��������
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	public PersonService personService;

	/**
	 * ��¼����ʧ�ܷ���error.jsp
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String dologin(String username, String password, Map<String, Object> map) {
		if (username.equals("admin") && password.equals("admin")) {
			map.put("username", username);//�����request��������
			/**
			 * ���ϼ���@SessionAttributes({"username"}) ͬʱҲ������ session����
			 * @SessionAttributes ���˿���ͨ��������ָ����Ҫ��ŵ��Ự�е�������(ʹ�õ���value����ֵ)
			 * ������ͨ��ģ�����ԵĶ�������ָ����Щģ��������Ҫ�ŵ��Ự��(ʵ����ʹ�õ���types����ֵ),
			 */
			return "frame";
		}
		return "error";
	}

	/**
	 * ������ӵ�����
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/saveperson")
	public String saveperson(Person person) {
		personService.addPerson(person);
		return "redirect:main";
	}

	/**
	 * ��ת�����ҳ��
	 * savepage.jsp
	 * @return
	 */
	@RequestMapping(value = "/addperson")
	public String saveperson() {

		return "savepage";
	}

	/**
	 * ɾ��һ������
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletePersonById")
	public String deletePersonById(@RequestParam(value = "id") String id) {
		System.out.println("ɾ������");
		personService.deletePersonById(id);
		return "redirect:main";
	}

	/**
	 * ��ת������ҳ�棬��������
	 * editpage.jsp
	 * @param id
	 * @param model ʹ�õ�Model�����������
	 * @return
	 */
	@RequestMapping(value = "/doupdate")
	public String doupdate(@RequestParam(value = "id") String id, Model model) {
		model.addAttribute("person", personService.getPersonById(id));
		return "editpage";
	}

	/**
	 * ��������
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/updateperson")
	public String updateperson(Person person) {
		System.out.println(person.toString());
		personService.updatePerson(person);
		return "redirect:main";
	}

	/**
	 * ��ѯ������Ա��Ϣ
	 * 
	 * @param map ʹ�õ���map�����������
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String mian(Map<String, Object> map) {
		map.put("personlist", personService.getPersons());
		/*�������ϣ��鿴��ѯ��������
		 * List<Person> lists = personService.getPersons(); 
		 * Iterator<Person> it = lists.iterator(); 
		 * while(it.hasNext()){ 
		 * 		Person p =it.next();
		 *	 	System.out.println(p.toString());
		 *  }
		 */
		return "main";
	}
}
