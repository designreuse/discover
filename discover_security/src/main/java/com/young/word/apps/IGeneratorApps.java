package com.young.word.apps;

import com.young.word.cage.IGenerator;
import com.young.word.cage.RandomTokenGenerator;

public class IGeneratorApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IGenerator<String> g=new RandomTokenGenerator();
		
		System.out.println(g.next());
	}

}
