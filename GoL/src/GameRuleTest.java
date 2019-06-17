import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GameRuleTest {
	private static GameRule gameRule=new GameRule(40,40);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testGenerate() {
		
		int[][] test=new int[12][12];
		int[][] re=new int[12][12];
		for(int i=0;i<12;i++)
			for(int k=0;k<12;k++) {
				test[i][k]=0;
				re[i][k]=0;
			}
		test[1][1]=1;
		test[1][2]=1;
		test[5][5]=1;
		test[5][6]=1;
		test[6][6]=1;
	
		
		//预测结果
		
		re [5][5]=1;
		re [5][6]=1;
		re [6][6]=1;
		re [6][5]=1;
		gameRule.setMap(test,12,12);
		//gameRule.setCurrent(test);
		gameRule.generate();
		for(int i=0;i<12;i++) {
			for(int j=0;j<12;j++) {
				assertEquals(re[i][j],gameRule.getNext()[i][j]);
			}
		}
		
	}

	@Test
	void testCellCount() {
		int[][] test=new int[12][12];
		int re;
		//初始化测试数据 
		for(int i=0;i<12;i++)
			for(int k=0;k<12;k++)
				test [i][k]=0;

		test[1][1]=1;
		test[1][2]=1;
		test[5][5]=1;
		test[5][6]=1;
		test[6][6]=1;
		re=2;
		gameRule.setCurrent(test);
		assertEquals(re,gameRule.cellCount(2, 2));
		/*
		for(int i=0;i<12;i++)
			for(int k=0;k<12;k++)
				re [i][k]=gameRule.cellCount(i, k);
				*/
		
		
		
	}

}
