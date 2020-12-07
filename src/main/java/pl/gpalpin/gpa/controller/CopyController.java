package pl.gpalpin.gpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.dto.TaskDto;
import pl.gpalpin.gpa.service.OfferService;

@Controller
public class CopyController {
	
	/*
	 * @Autowired private OfferService offerService;
	 * 
	 * @RequestMapping({"/copy"}) public String main(Model model) {
	 * model.addAttribute("offerToCreate", new OfferDto()); return "copy"; }
	 * 
	 * @RequestMapping(value="/copy", params={"save"}) public String
	 * saveSeedstarter(final OfferDto offerToCreate, final BindingResult
	 * bindingResult, final ModelMap model) { if (bindingResult.hasErrors()) {
	 * return "copy"; } this.offerService.addOffer(offerToCreate); model.clear();
	 * return "redirect:/copy"; }
	 * 
	 * 
	 * @RequestMapping(value="/copy", params={"addTask"}) public String
	 * addTask(final OfferDto offerToCreate, final BindingResult bindingResult) {
	 * offerToCreate.getScopeOfWork().add(new TaskDto()); return "form"; }
	 */

}
