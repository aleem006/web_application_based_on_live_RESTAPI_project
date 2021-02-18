package com.vac.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vac.model.Certificate;
import com.vac.model.Vessel;

@Controller
public class MainController {

	public static ArrayList<Vessel> vesselList = new ArrayList<Vessel>();
<<<<<<< HEAD
	
	//Main Page
=======

>>>>>>> a33bf6ebc3551cebf0358239de9a8c5b48c9927a
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response)
			throws JSONException, IOException {
		ModelAndView mav = new ModelAndView("main1");
		if (vesselList.size() <= 0)
			vesselList = readJsonFromUrl("https://extranet-api.skuld.com/vesselsearch/?query=tiger");
		mav.addObject("vesselList", vesselList);
		return mav;
	}

<<<<<<< HEAD
	//opens the viewCertificate page
=======
>>>>>>> a33bf6ebc3551cebf0358239de9a8c5b48c9927a
	@RequestMapping(value = "/viewCertificate", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("certificate");
		String imo = request.getParameter("imo");
		String vesselType = request.getParameter("vesselType");
		String note = request.getParameter("note");
		Vessel vessel = new Vessel();
		for (Vessel v : vesselList) {
			if (v.getImo().equals(imo) && v.getVesselType().equals(vesselType) && v.getNote().equals(note)) {
				vessel = v;
				break;
			}
		}
		String vesselData = "Vessel Name: " + vessel.getVesselName() + "\nNote: " + vessel.getNote() + "\nMember: "
				+ vessel.getMember() + "\nImo: " + vessel.getImo() + "\nBuilt Year: " + vessel.getBuiltYear()
				+ "\nGross Tonnage: " + vessel.getGrossTonnage() + "\nVessel Type: " + vessel.getVesselType()
				+ "\nFlag Description: " + vessel.getFlagDescription() + "\nBusiness Unit: " + vessel.getBusinessUnit()
				+ "\nCurrent Reg Owner: " + vessel.getCurrentRegOwner();
		mav.addObject("vesselData", vesselData);
		System.out.println(vesselData + "\n");
		mav.addObject("vessel", vessel);
		mav.addObject("note1", vessel.getNote());
		mav.addObject("certificateList", vessel.certificateList);
		return mav;
	}

<<<<<<< HEAD
	//Readall method just fetches the stream of letters and generating string using string builder
=======
>>>>>>> a33bf6ebc3551cebf0358239de9a8c5b48c9927a
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

<<<<<<< HEAD
	//hits the url, and parses json
=======
>>>>>>> a33bf6ebc3551cebf0358239de9a8c5b48c9927a
	public static ArrayList<Vessel> readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			ArrayList<Vessel> vesselList = new ArrayList<Vessel>();
			Vessel vessel = null;
			Certificate certificate = null;
			JSONArray jsonArray = new JSONArray(jsonText);
			for (int i = 0; i < jsonArray.length(); i++) {
				if (jsonArray.get(i) instanceof JSONObject) {
					JSONObject jsnObj = (JSONObject) jsonArray.get(i);
					vessel = new Vessel();
					vessel.setVesselName(jsnObj.get("vesselName") != null ? (String) jsnObj.get("vesselName") : "");
					if (jsnObj.get("note") != null) {
						if (jsnObj.get("note") instanceof String)
							vessel.setNote((String) jsnObj.get("note"));
						else
							vessel.setNote("");
					} else
						vessel.setNote("");
					vessel.setMember(jsnObj.get("member") != null ? (String) jsnObj.get("member") : "");
					vessel.setImo(jsnObj.get("imo") != null ? (String) jsnObj.get("imo") : "");
					vessel.setBuiltYear(jsnObj.get("builtYear") != null ? (String) jsnObj.get("builtYear") : "");
					vessel.setGrossTonnage(
							jsnObj.get("grossTonnage") != null ? (String) jsnObj.get("grossTonnage") : "");
					vessel.setVesselType(jsnObj.get("vesselType") != null ? (String) jsnObj.get("vesselType") : "");
					vessel.setFlagDescription(
							jsnObj.get("flagDescription") != null ? (String) jsnObj.get("flagDescription") : "");
					vessel.setBusinessUnit(
							jsnObj.get("businessUnit") != null ? (String) jsnObj.get("businessUnit") : "");
					vessel.setCurrentRegOwner(
							jsnObj.get("currentRegOwner") != null ? (String) jsnObj.get("currentRegOwner") : "");
					JSONArray certificateArray = (JSONArray) jsnObj.get("certificates");
					for (int j = 0; j < certificateArray.length(); j++) {
						try {
							if (certificateArray.get(j) != null) {
								if (certificateArray.get(j) instanceof JSONObject) {
									JSONObject certJsonObj = (JSONObject) certificateArray.get(j);
									certificate = new Certificate();
									certificate.setCertificate(certJsonObj.get("certificate") != null
											? (String) certJsonObj.get("certificate")
											: "");
									certificate.setCertificateType(certJsonObj.get("certificateType") != null
											? (String) certJsonObj.get("certificateType")
											: "");
									certificate.setVesselImo(vessel.getImo());
									certificate.setVesselType(vessel.getVesselType());
									vessel.certificateList.add(certificate);
								}
							}
						} catch (Exception e) {
							System.out.println(e.getLocalizedMessage());
						}
					}
				}
				vesselList.add(vessel);
			}
			return vesselList;
		} finally {
			is.close();
		}
	}
}
