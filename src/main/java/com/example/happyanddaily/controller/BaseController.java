package com.example.happyanddaily.controller;

import com.example.happyanddaily.domain.menu.entity.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BaseController {

    @GetMapping("/")
    public String base(Model model){

        Menu menu1 = new Menu();
        menu1.setMenu_name("컵과일, 과일컵 이 일대에서는 이집이 최고 입니다.(12온즈)");
        menu1.setMenu_price(new BigDecimal(4900));
        menu1.setCategory_main("대표메뉴");
        menu1.setCategory_sub("");
        menu1.setMenu_description("아래 준비된 과일 중 6~7가지 정도로 배달됩니다. 컵과일은 시간이 많이 소요 됩니다. 품절로 되어 있거나 가게가 임시중지라도 컵과일 주문은 가게로 연락 부탁 드립니다. 010칠육일오7953 1.사과 2.단감 3.배 4.스테비아방울토마토or방울토마토 5.크림슨적포도or청포도 6.오렌지 7.그린키위 8.골드키위 9.감귤 10.파인애플 11.만감류(한라봉,레드향,천혜향,황금향) 12.딸기 13.용과 14.바나나 15.블루베리");

        Menu menu2 = new Menu();
        menu2.setMenu_name("피부를 그대에게 애플망고(한개)");
        menu2.setMenu_price(new BigDecimal(15000));
        menu2.setCategory_main("대표메뉴");
        menu2.setCategory_sub("");
        menu2.setMenu_description("다른 가게와 가격 비교해보세요. 이번에 구매한 애플망고는 상당히 괜찮습니다. 피부미용과 눈 건강에 도움이 된다고 합니다. 약 450~500g 정도 되는 페루산 애플망고 입니다. 비교적 큰 편입니다.10% 미만의 에어포켓은 그대로 배달 됩니다. 생과일 그대로 구매하는 것도 고려해 보세요.");

        Menu menu3 = new Menu();
        menu3.setMenu_name("향도 맛도 좋은 딸기(죽향250g이상(소))");
        menu3.setMenu_price(new BigDecimal(11000));
        menu3.setCategory_main("대표메뉴");
        menu3.setCategory_sub("");
        menu3.setMenu_description("딸기가 끝물이라서 괜찮은 딸기를 하도 구하기 어려워 거의 최고가인 죽향 딸기만 매입해 왔습니다. 같은 딸기라도 품종에 따라 시장 가면 가격 차이가 꽤 있습니다. 참고해주세요.");

        List<Menu> arrayList = new ArrayList<Menu>();
        arrayList.add(menu1);
        arrayList.add(menu2);
        arrayList.add(menu3);
//        arrayList.add(menu1);
//        arrayList.add(menu2);
//        arrayList.add(menu3);
//        arrayList.add(menu1);
//        arrayList.add(menu2);
//        arrayList.add(menu3);
//        arrayList.add(menu1);
//        arrayList.add(menu2);
//        arrayList.add(menu3);
        model.addAttribute("arrayList", arrayList);

        return "/layout/base";
    }

    @GetMapping("/base")
    public String base2(){
        return "/layout/base";
    }

}
