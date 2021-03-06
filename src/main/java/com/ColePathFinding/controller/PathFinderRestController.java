package com.ColePathFinding.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProtoPathing.cole.MyList.ListType;
import ProtoPathing.cole.ProtoSearchAgent;
import ProtoPathing.cole.ProtoSearchAgentAStar;
import ProtoPathing.cole.ProtoMap;

@CrossOrigin
@RestController
public class PathFinderRestController {

	@GetMapping("/astar")
	String getAStartPath() {
		Stack<ProtoMap> pathToGoal = new ProtoSearchAgentAStar("src/main/resources/TestMap.txt").getPathToGoal();
		String finalPath = new String();
		finalPath += pathToGoal.get(0).getPlayerPosition()[0] + " " + pathToGoal.get(0).getPlayerPosition()[1] + ",";
		finalPath += pathToGoal.get(0).getGoalPosition()[0] + " " + pathToGoal.get(0).getGoalPosition()[1] + ",";
		for(ProtoMap pm: pathToGoal) {
			finalPath += pm.toString() + ",";
		}
		System.out.println(finalPath);
		return finalPath;
	}
	
	@GetMapping("/dfs")
	String getDFS() {
		Stack<ProtoMap> pathToGoal = new ProtoSearchAgent( ListType.Stack ,"src/main/resources/TestMap.txt").getPathToGoal();
		String finalPath = new String();
		finalPath += pathToGoal.get(0).getPlayerPosition()[0] + " " + pathToGoal.get(0).getPlayerPosition()[1] + ",";
		finalPath += pathToGoal.get(0).getGoalPosition()[0] + " " + pathToGoal.get(0).getGoalPosition()[1] + ",";
		for(ProtoMap pm: pathToGoal) {
			finalPath += pm.toString() + ",";
		}
		System.out.println(finalPath);
		return finalPath;
	}
	
	@GetMapping("/bfs")
	String getBFS() {
		Stack<ProtoMap> pathToGoal = new ProtoSearchAgent( ListType.Queue ,"src/main/resources/TestMap.txt").getPathToGoal();
		String finalPath = new String();
		finalPath += pathToGoal.get(0).getPlayerPosition()[0] + " " + pathToGoal.get(0).getPlayerPosition()[1] + ",";
		finalPath += pathToGoal.get(0).getGoalPosition()[0] + " " + pathToGoal.get(0).getGoalPosition()[1] + ",";
		for(ProtoMap pm: pathToGoal) {
			finalPath += pm.toString() + ",";
		}
		System.out.println(finalPath);
		return finalPath;
	}
	
}
