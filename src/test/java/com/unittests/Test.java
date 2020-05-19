package com.unittests;

import com.aws.utils.AWSS3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AWSS3 s=new AWSS3();
		try {
			//s.downloadS3Object("us-west-2","cl-us-west-2-cc-dev-content-ingestion","stable/output/publications/Pegasus/Product/manual/91608613087_2018-12-12_05-19-47.zip", "91608613087_2018-12-12_05-19-47.zip", "KORADA");
			// s.listS3Objects("us-west-2","cl-us-west-2-cc-dev-content-ingestion","stable/output/publications/Pegasus/Product/manual/");
			/*s.deleteRecords("jdbc:oracle:thin:@biblio-test.czazctzymxax.us-west-2.rds.amazonaws.com:1521:ampall","biblio_user", "biblio_user","delete from TRACK_PIPS where acquisition_id='330277651'");
			s.deleteRecords("jdbc:oracle:thin:@biblio-test.czazctzymxax.us-west-2.rds.amazonaws.com:1521:ampall","biblio_user", "biblio_user","delete from acquisition where acquisition_id='330277651'");	
			s.uploadObject("us-west-2","cl-us-west-2-cc-dev-content-ingestion","stable/input/publications/bundles/330277651_20181130033704940.zip","C:\\Users\\42131\\Downloads\\330277651_20181130033704940.zip");*/
			
			s.fetchRecords("jdbc:oracle:thin:@biblio-test.czazctzymxax.us-west-2.rds.amazonaws.com:1521:ampall","biblio_user", "biblio_user","select PUBL_INSTANCE_ID from TRACK_PIPS where acquisition_id='330277651'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
