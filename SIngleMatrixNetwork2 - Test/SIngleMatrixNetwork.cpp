// SIngleMatrixNetwork.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Network.h"
#include <math.h>
#include <stdio.h>

int main(int argc, char* argv[])
{
	double input[6];
	int i,j;
	
	Network net_test("sample_network.txt");

	i = 0;
	
	while (i < 1000) {

		input[0] = 0;
		if (i > 1 && i <= 100) input[0] = 1;
		if (i > 100 && i <= 200) input[0] = 0;
		if (i > 200 && i <= 300) input[0] = 1;
		if (i > 400 && i <= 500) input[0] = 0;
		if (i > 500 && i <= 600) input[0] = 1;
		if (i > 600 && i <= 700) input[0] = 0;
		if (i > 700 && i <= 800) input[0] = 1;
		if (i > 800 && i <= 900) input[0] = 0;
		if (i > 900 && i <= 1000) input[0] = 1;
		
		net_test.setNetworkInput(input);
		net_test.cycleNetwork();
		net_test.printNetworkOuput();
		net_test.printNetworkOutputState();
		net_test.writeNetworkOutputStateToFile("sample_output.txt");

		++i;
	}




	//Network ted(3,10,2,"blank_network.txt");

//	Network fred;
	//Network fred("antJaw_01.txt");

	//fred.PrintNetworkState();


	// Initialize the weights to produce a test recurrent network
/*
	fred.setNetworkWeights(0.0);					// initialize all connections to zero
	fred.setNetworkWeightsRectangle(0.3,3,7,0,3);	// set feedforward connections from inputs to interneurons 
	fred.setNetworkWeightsRectangle(0.5,7,9,3,7);	// set feedforward connections from interneurons to output neurons 
	fred.setNetworkWeightsRectangle(-0.25,3,7,3,7);	// set recurrent connections from interneurons to interneurons
	fred.setNetworkWeightsDiagonalRange(0.1,0,9);	// set network autapses
  */

/*	
	//--- Identity Matrix ----
	fred.setNetworkWeights(0.0);
	fred.setNetworkWeightsDiagonalRange(1,0,8);
*/

	//fred.writeNetworkOutputStateToFile( "output.txt" );
/*
	i = 0;
	while( i < 1000 ){

		
		input[0] = input[1] = input[2]	= 0.0;			// Set all inputs off
		if( i>25 && i < 100)	input[0] = 1.0;		// Command jaw close on between time 25 and 100
		if( i>300 && i < 600)	input[0] = 1.0;		// Command jaw close	on between time = 300 and 600
		if( i> 400 && i < 500) input[1] = 1.0;		// command right jaw open between time = 400 and 500
		if( i> 450 && i < 500) input[1] = 1.0;		// command right jaw open between time = 400 and 500


		//-----------------------------------------------------------
		for(j = 0; j < 6; ++j ){	// temporary input function (STEP RESPONSE)
			input[j]  =  sin((i + j*3)*0.01*i);
//			input[j]  = 1.0;
		}
		//---------------------------------------------------------------------

		fred.setNetworkInput( input );

		fred.cycleNetwork();

//		fred.cycleNetworkNormalizeHebbianLearning();

//		fred.printNetworkOuput();
		fred.printNetworkOutputState( );

		fred.writeNetworkOutputStateToFile( "output.txt" );

		fred.writeNetworkToFile("test.txt");
		fred.writeNetworkWeightsToFile("weights.txt");
		++i;
	}

	//Test the read-write fucntions -------------
	fred.writeNetworkToFile("temp.txt");
//	fred.readNetworkFromFile("temp.txt");
*/
	return 0;
}
