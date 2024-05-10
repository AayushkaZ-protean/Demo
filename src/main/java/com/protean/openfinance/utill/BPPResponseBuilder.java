package com.protean.openfinance.utill;

import com.nsdl.beckn.api.model.common.Context;

import java.time.LocalDateTime;

public class BPPResponseBuilder {
	
	private static final String BPP_ID = "sandbox.onest.network/adaptor-bpp/smartlab";
	private static final String BPP_URL = "https://sandbox.onest.network/adaptor-bpp/smartlab/bpp";
	
	public static String onSearchOld(Context ctx) {
    	return "{\r\n"
    			+ "    \"context\": {\r\n"
    			+ "        \"domain\": \""
    			+ ctx.getDomain()
    			+ "\",\r\n"
    			+ "        \"version\": \""
    		//	+ "1.0.0"
    			+ ctx.getCoreVersion()
    			+ "\",\r\n"
    			+ "        \"action\": \"on_search\",\r\n"
    			+ "        \"bap_id\": \""
    		//	+ "0c03-114-143-139-186.ngrok-free.app/rv-bap"
    			+ ctx.getBapId()
    			+ "\",\r\n"
    			+ "        \"bap_uri\": \""
//    			+ "https://0c03-114-143-139-186.ngrok-free.app/rv-bap/bap"
    			+ ctx.getBapUri()
    			+ "\",\r\n"
    			+ "        \"transaction_id\": \""
//    			+ "a9aaecca-10b7-4d19-b640-b047a7c62196"
    			+ ctx.getTransactionId()
    			+ "\",\r\n"
    			+ "        \"message_id\": \""
//    			+ "0d30bfbf-87b8-43d2-8f95-36ebb9a24fd6"
    			+ ctx.getMessageId()
    			+ "\",\r\n"
    			+ "        \"ttl\": \"PT10M\",\r\n"
    			+ "        \"timestamp\": \"2023-02-22T10:30:18.145Z\",\r\n"
    			+ "        \"bpp_id\": \""
//    			+ "2b69-114-143-139-186.ngrok-free.app/rv-bpp"
    			+ ctx.getBppId()
    			+ "\",\r\n"
    			+ "        \"bpp_uri\": \""
//    			+ "https://2b69-114-143-139-186.ngrok-free.app/rv-bpp/bpp"
    			+ ctx.getBppUri()
    			+ "\"\r\n"
    			+ "    },\r\n"
    			+ "    \"message\": {\r\n"
    			+ "        \"catalog\": {\r\n"
    			+ "            \"descriptor\": {\r\n"
    			+ "                \"name\": \"Catalog for undefined\"\r\n"
    			+ "            },\r\n"
    			+ "            \"providers\": [\r\n"
    			+ "                {\r\n"
    			+ "                    \"id\": \"NCERT\",\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                        \"name\": \"NCERT\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"categories\": [\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"SCHOOL\",\r\n"
    			+ "                            \"parent_category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"SCHOOL\"\r\n"
    			+ "                            }\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"SCHOOL\",\r\n"
    			+ "                            \"parent_category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"SCHOOL\"\r\n"
    			+ "                            }\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"SCHOOL\",\r\n"
    			+ "                            \"parent_category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"SCHOOL\"\r\n"
    			+ "                            }\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"SCHOOL\",\r\n"
    			+ "                            \"parent_category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"SCHOOL\"\r\n"
    			+ "                            }\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"SCHOOL\",\r\n"
    			+ "                            \"parent_category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"SCHOOL\"\r\n"
    			+ "                            }\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"SCHOOL\",\r\n"
    			+ "                            \"parent_category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"SCHOOL\"\r\n"
    			+ "                            }\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"SCHOOL\",\r\n"
    			+ "                            \"parent_category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"SCHOOL\"\r\n"
    			+ "                            }\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"SCHOOL\",\r\n"
    			+ "                            \"parent_category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"SCHOOL\"\r\n"
    			+ "                            }\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"SCHOOL\",\r\n"
    			+ "                            \"parent_category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"SCHOOL\"\r\n"
    			+ "                            }\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"SCHOOL\",\r\n"
    			+ "                            \"parent_category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"SCHOOL\"\r\n"
    			+ "                            }\r\n"
    			+ "                        }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"items\": [\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"Q291cnNlTGlzdDovbmQyX25jZTIyX3NjMjk=\",\r\n"
    			+ "                            \"parent_item_id\": \"Q291cnNlTGlzdDovbmQyX25jZTIyX3NjMjk=\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"Accountancy XI Part-I\",\r\n"
    			+ "                                \"long_desc\": \"\",\r\n"
    			+ "                                \"images\": [\r\n"
    			+ "                                    {\r\n"
    			+ "                                        \"url\": \"https://storage.googleapis.com/swayam-node2-production.appspot.com/assets/img/nce22_sc29/accountancy01-01%20(4).jpg\"\r\n"
    			+ "                                    }\r\n"
    			+ "                                ]\r\n"
    			+ "                            },\r\n"
    			+ "                            \"price\": {\r\n"
    			+ "                                \"currency\": \"INR\",\r\n"
    			+ "                                \"value\": \"0\"\r\n"
    			+ "                            },\r\n"
    			+ "                            \"category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"recommended\": false,\r\n"
    			+ "                            \"time\": {\r\n"
    			+ "                                \"label\": \"Course Schedule\",\r\n"
    			+ "                                \"duration\": \"P24W\",\r\n"
    			+ "                                \"range\": {\r\n"
    			+ "                                    \"start\": \"2022-11-01T18:29:00.000000Z\",\r\n"
    			+ "                                    \"end\": \"2023-03-31T18:29:00.000000Z\"\r\n"
    			+ "                                }\r\n"
    			+ "                            },\r\n"
    			+ "                            \"rating\": \"3\",\r\n"
    			+ "                            \"tags\": [\r\n"
    			+ "                                {\r\n"
    			+ "                                    \"descriptor\": {\r\n"
    			+ "                                        \"name\": \"courseInfo\"\r\n"
    			+ "                                    },\r\n"
    			+ "                                    \"list\": [\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"credits\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"null\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"instructors\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"Prof. Shipra Vaidya\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"offeringInstitue\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"DESS, NCERT, New Delhi\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"url\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"https://onlinecourses.swayam2.ac.in/nce22_sc29/preview\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"decsriptor\": {\r\n"
    			+ "                                                \"name\": \"enrollmentEndDate\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"2023-02-28T18:29:00.000000Z\"\r\n"
    			+ "                                        }\r\n"
    			+ "                                    ],\r\n"
    			+ "                                    \"display\": true\r\n"
    			+ "                                }\r\n"
    			+ "                            ],\r\n"
    			+ "                            \"rateable\": false\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"Q291cnNlTGlzdDovbmQyX25jZTIyX3NjMzA=\",\r\n"
    			+ "                            \"parent_item_id\": \"Q291cnNlTGlzdDovbmQyX25jZTIyX3NjMzA=\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"Biology XI Part-I\",\r\n"
    			+ "                                \"long_desc\": \"\",\r\n"
    			+ "                                \"images\": [\r\n"
    			+ "                                    {\r\n"
    			+ "                                        \"url\": \"https://storage.googleapis.com/swayam-node2-production.appspot.com/assets/img/nce22_sc30/biology01.jpg\"\r\n"
    			+ "                                    }\r\n"
    			+ "                                ]\r\n"
    			+ "                            },\r\n"
    			+ "                            \"price\": {\r\n"
    			+ "                                \"currency\": \"INR\",\r\n"
    			+ "                                \"value\": \"0\"\r\n"
    			+ "                            },\r\n"
    			+ "                            \"category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"recommended\": false,\r\n"
    			+ "                            \"time\": {\r\n"
    			+ "                                \"label\": \"Course Schedule\",\r\n"
    			+ "                                \"duration\": \"P24W\",\r\n"
    			+ "                                \"range\": {\r\n"
    			+ "                                    \"start\": \"2022-11-01T18:29:00.000000Z\",\r\n"
    			+ "                                    \"end\": \"2023-03-31T18:29:00.000000Z\"\r\n"
    			+ "                                }\r\n"
    			+ "                            },\r\n"
    			+ "                            \"rating\": \"1\",\r\n"
    			+ "                            \"tags\": [\r\n"
    			+ "                                {\r\n"
    			+ "                                    \"descriptor\": {\r\n"
    			+ "                                        \"name\": \"courseInfo\"\r\n"
    			+ "                                    },\r\n"
    			+ "                                    \"list\": [\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"credits\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"null\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"instructors\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"Dr. Pushpalatha\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"offeringInstitue\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"DESM, NCERT, New Delhi\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"url\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"https://onlinecourses.swayam2.ac.in/nce22_sc30/preview\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"decsriptor\": {\r\n"
    			+ "                                                \"name\": \"enrollmentEndDate\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"2023-02-28T18:29:00.000000Z\"\r\n"
    			+ "                                        }\r\n"
    			+ "                                    ],\r\n"
    			+ "                                    \"display\": true\r\n"
    			+ "                                }\r\n"
    			+ "                            ],\r\n"
    			+ "                            \"rateable\": false\r\n"
    			+ "                        },\r\n"
    			+ "                        {\r\n"
    			+ "                            \"id\": \"Q291cnNlTGlzdDovbmQyX25jZTIyX3NjMzE=\",\r\n"
    			+ "                            \"parent_item_id\": \"Q291cnNlTGlzdDovbmQyX25jZTIyX3NjMzE=\",\r\n"
    			+ "                            \"descriptor\": {\r\n"
    			+ "                                \"name\": \"Biology XI Part-II\",\r\n"
    			+ "                                \"long_desc\": \"\",\r\n"
    			+ "                                \"images\": [\r\n"
    			+ "                                    {\r\n"
    			+ "                                        \"url\": \"https://storage.googleapis.com/swayam-node2-production.appspot.com/assets/img/nce22_sc31/biology02.jpg\"\r\n"
    			+ "                                    }\r\n"
    			+ "                                ]\r\n"
    			+ "                            },\r\n"
    			+ "                            \"price\": {\r\n"
    			+ "                                \"currency\": \"INR\",\r\n"
    			+ "                                \"value\": \"0\"\r\n"
    			+ "                            },\r\n"
    			+ "                            \"category_id\": \"SCHOOL\",\r\n"
    			+ "                            \"recommended\": false,\r\n"
    			+ "                            \"time\": {\r\n"
    			+ "                                \"label\": \"Course Schedule\",\r\n"
    			+ "                                \"duration\": \"P24W\",\r\n"
    			+ "                                \"range\": {\r\n"
    			+ "                                    \"start\": \"2022-11-01T18:29:00.000000Z\",\r\n"
    			+ "                                    \"end\": \"2023-03-31T18:29:00.000000Z\"\r\n"
    			+ "                                }\r\n"
    			+ "                            },\r\n"
    			+ "                            \"rating\": \"0\",\r\n"
    			+ "                            \"tags\": [\r\n"
    			+ "                                {\r\n"
    			+ "                                    \"descriptor\": {\r\n"
    			+ "                                        \"name\": \"courseInfo\"\r\n"
    			+ "                                    },\r\n"
    			+ "                                    \"list\": [\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"credits\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"null\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"instructors\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"Dr. Pushpalatha\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"offeringInstitue\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"DESM, NCERT, New Delhi\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"descriptor\": {\r\n"
    			+ "                                                \"name\": \"url\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"https://onlinecourses.swayam2.ac.in/nce22_sc31/preview\"\r\n"
    			+ "                                        },\r\n"
    			+ "                                        {\r\n"
    			+ "                                            \"decsriptor\": {\r\n"
    			+ "                                                \"name\": \"enrollmentEndDate\"\r\n"
    			+ "                                            },\r\n"
    			+ "                                            \"value\": \"2023-02-28T18:29:00.000000Z\"\r\n"
    			+ "                                        }\r\n"
    			+ "                                    ],\r\n"
    			+ "                                    \"display\": true\r\n"
    			+ "                                }\r\n"
    			+ "                            ],\r\n"
    			+ "                            \"rateable\": false\r\n"
    			+ "                        }\r\n"
    			+ "                    ]\r\n"
    			+ "                }\r\n"
    			+ "            ]\r\n"
    			+ "        }\r\n"
    			+ "    }\r\n"
    			+ "}";
    }
    
    public static String onSelectOld(Context ctx) {
    	return "{\r\n"
    			+ "        \"context\": {\r\n"
    			+ "          \"domain\": \"onest:learning-experiences\",\r\n"
    			+ "          \"version\": \"1.0.0\",\r\n"
    			+ "          \"action\": \"on_select\",\r\n"
    			+ "        \"bap_id\": \"0c03-114-143-139-186.ngrok-free.app/rv-bap\",\r\n"
    			+ "        \"bap_uri\": \"https://0c03-114-143-139-186.ngrok-free.app/rv-bap/bap\",\r\n"
    			+ "        \"transaction_id\": \"a9aaecca-10b7-4d19-b640-b047a7c62196\",\r\n"
    			+ "        \"message_id\": \"0d30bfbf-87b8-43d2-8f95-36ebb9a24fd6\",\r\n"
    			+ "        \"ttl\": \"PT10M\",\r\n"
    			+ "        \"timestamp\": \"2023-02-22T10:30:18.145Z\",\r\n"
    			+ "        \"bpp_id\": \"2b69-114-143-139-186.ngrok-free.app/rv-bpp\",\r\n"
    			+ "        \"bpp_uri\": \"https://2b69-114-143-139-186.ngrok-free.app/rv-bpp/bpp\"\r\n"
    			+ "        },\r\n"
    			+ "        \"message\": {\r\n"
    			+ "          \"order\": {\r\n"
    			+ "            \"provider\": {\r\n"
    			+ "              \"id\": \"CEC\",\r\n"
    			+ "              \"descriptor\": {\r\n"
    			+ "                \"name\": \"CEC\"\r\n"
    			+ "              },\r\n"
    			+ "              \"category_id\": \"COMP_SCI_ENGG\"\r\n"
    			+ "            },\r\n"
    			+ "            \"items\": [\r\n"
    			+ "              {\r\n"
    			+ "                \"id\": \"Q291cnNlTGlzdDovbmQyX2NlYzIzX2NzMDI=\",\r\n"
    			+ "                \"parent_item_id\": \"Q291cnNlTGlzdDovbmQyX2NlYzIzX2NzMDI=\",\r\n"
    			+ "                \"descriptor\": {\r\n"
    			+ "                  \"name\": \"Problem solving Aspects and Python Programming\",\r\n"
    			+ "                  \"long_desc\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\",\r\n"
    			+ "                  \"images\": [\r\n"
    			+ "                    {\r\n"
    			+ "                      \"url\": \"https://storage.googleapis.com/swayam-node2-production.appspot.com/assets/img/cec20_cs04/Course%20Image.png\"\r\n"
    			+ "                    }\r\n"
    			+ "                  ]\r\n"
    			+ "                },\r\n"
    			+ "                \"price\": {\r\n"
    			+ "                  \"currency\": \"INR\",\r\n"
    			+ "                  \"value\": \"0\"\r\n"
    			+ "                },\r\n"
    			+ "                \"category_id\": \"COMP_SCI_ENGG\",\r\n"
    			+ "                \"recommended\": false,\r\n"
    			+ "                \"time\": {\r\n"
    			+ "                  \"label\": \"Course Schedule\",\r\n"
    			+ "                  \"duration\": \"P12W\",\r\n"
    			+ "                  \"range\": {\r\n"
    			+ "                    \"start\": \"2023-01-17T18:30:00.000000Z\",\r\n"
    			+ "                    \"end\": \"2023-04-09T18:29:00.000000Z\"\r\n"
    			+ "                  }\r\n"
    			+ "                },\r\n"
    			+ "                \"rating\": \"1\",\r\n"
    			+ "                \"tags\": [\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"courseDetails\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"credits\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"4\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"instructors\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"offeringInstitue\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Kongu Engineering College\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"url\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"enrollmentEndDate\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"2023-02-28T18:29:00.000000Z\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  },\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"eligibility\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion1\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion2\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion3\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion4\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  },\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"courseHighlights\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight1\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight2\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight3\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight4\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  },\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"prerequisites\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite1\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite2\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite3\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite4\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  }\r\n"
    			+ "                ],\r\n"
    			+ "                \"rateable\": false\r\n"
    			+ "              }\r\n"
    			+ "            ],\r\n"
    			+ "            \"type\": \"DEFAULT\"\r\n"
    			+ "          }\r\n"
    			+ "        }\r\n"
    			+ "      }";
    }
    
    public static String onInitOld(Context ctx) {
    	return "{\r\n"
    			+ "        \"context\": {\r\n"
    			+ "          \"domain\": \"onest:learning-experiences\",\r\n"
    			+ "          \"version\": \"1.0.0\",\r\n"
    			+ "          \"action\": \"on_init\",\r\n"
    			+ "        \"bap_id\": \"sandbox.onest.network/adaptor-bap/knimbus\",\r\n"
    			+ "        \"bap_uri\": \"https://sandbox.onest.network/adaptor-bap/knimbus/bap\",\r\n"
    			+ "        \"transaction_id\": \"7a618dc4-c2d6-4c30-a546-1c59bc85946c\",\r\n"
    			+ "        \"message_id\": \"0d30bfbf-87b8-43d2-8f95-36ebb9a24fd6\",\r\n"
    			+ "        \"ttl\": \"PT10M\",\r\n"
    			+ "        \"timestamp\": \""+ LocalDateTime.now().toString() +"\",\r\n"
    			+ "        \"bpp_id\": \"sandbox.onest.network/adaptor-bpp/smartlab\",\r\n"
    			+ "        \"bpp_uri\": \"https://sandbox.onest.network/adaptor-bpp/smartlab/bpp\"\r\n"
    			+ "        },\r\n"
    			+ "        \"message\": {\r\n"
    			+ "          \"order\": {\r\n"
    			+ "            \"provider\": {\r\n"
    			+ "              \"id\": \"CEC\",\r\n"
    			+ "              \"descriptor\": {\r\n"
    			+ "                \"name\": \"CEC\"\r\n"
    			+ "              },\r\n"
    			+ "              \"category_id\": \"COMP_SCI_ENGG\"\r\n"
    			+ "            },\r\n"
    			+ "            \"items\": [\r\n"
    			+ "              {\r\n"
    			+ "                \"id\": \"Q291cnNlTGlzdDovbmQyX2NlYzIzX2NzMDI=\",\r\n"
    			+ "                \"parent_item_id\": \"Q291cnNlTGlzdDovbmQyX2NlYzIzX2NzMDI=\",\r\n"
    			+ "                \"descriptor\": {\r\n"
    			+ "                  \"name\": \"Problem solving Aspects and Python Programming\",\r\n"
    			+ "                  \"long_desc\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\",\r\n"
    			+ "                  \"images\": [\r\n"
    			+ "                    {\r\n"
    			+ "                      \"url\": \"https://storage.googleapis.com/swayam-node2-production.appspot.com/assets/img/cec20_cs04/Course%20Image.png\"\r\n"
    			+ "                    }\r\n"
    			+ "                  ]\r\n"
    			+ "                },\r\n"
    			+ "                \"price\": {\r\n"
    			+ "                  \"currency\": \"INR\",\r\n"
    			+ "                  \"value\": \"0\"\r\n"
    			+ "                },\r\n"
    			+ "                \"category_id\": \"COMP_SCI_ENGG\",\r\n"
    			+ "                \"recommended\": false,\r\n"
    			+ "                \"time\": {\r\n"
    			+ "                  \"label\": \"Course Schedule\",\r\n"
    			+ "                  \"duration\": \"P12W\",\r\n"
    			+ "                  \"range\": {\r\n"
    			+ "                    \"start\": \"2023-01-17T18:30:00.000000Z\",\r\n"
    			+ "                    \"end\": \"2023-04-09T18:29:00.000000Z\"\r\n"
    			+ "                  }\r\n"
    			+ "                },\r\n"
    			+ "                \"rating\": \"5\",\r\n"
    			+ "                \"tags\": [\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"courseDetails\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"credits\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"4\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"instructors\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"offeringInstitue\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Kongu Engineering College\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"url\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"enrollmentEndDate\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"2023-02-28T18:29:00.000000Z\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  },\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"eligibility\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion1\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion2\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion3\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion4\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  },\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"courseHighlights\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight1\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight2\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight3\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight4\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  },\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"prerequisites\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite1\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite2\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite3\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite4\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  }\r\n"
    			+ "                ],\r\n"
    			+ "                \"rateable\": false\r\n"
    			+ "              }\r\n"
    			+ "            ],\r\n"
    			+ "            \"fulfillments\": [\r\n"
    			+ "              {\r\n"
    			+ "                \"customer\": {\r\n"
    			+ "                  \"person\": {\r\n"
    			+ "                    \"name\": \"John Doe\"\r\n"
    			+ "                  }\r\n"
    			+ "                },\r\n"
    			+ "                \"tracking\": false\r\n"
    			+ "              }\r\n"
    			+ "            ],\r\n"
    			+ "            \"type\": \"DEFAULT\"\r\n"
    			+ "          }\r\n"
    			+ "        }\r\n"
    			+ "      }";
    }
    
    public static String onConfirmOld(Context ctx) {
    	return "{\r\n"
				+ "        \"context\": {\r\n"
			+ "            \"domain\": \"onest:learning-experiences\",\r\n"
			+ "            \"version\": \"1.0.0\",\r\n"
			+ "            \"action\": \"on_confirm\",\r\n"
				+ "        \"bap_id\": \"sandbox.onest.network/adaptor-bap/knimbus\",\r\n"
				+ "        \"bap_uri\": \"https://sandbox.onest.network/adaptor-bap/knimbus/bap\",\r\n"
				+ "        \"transaction_id\": \"7a618dc4-c2d6-4c30-a546-1c59bc85946c\",\r\n"
				+ "        \"message_id\": \"780162e6-37f3-4caf-95dc-9d438aeabc2a\",\r\n"
				+ "        \"ttl\": \"PT10M\",\r\n"
				+ "        \"timestamp\": \"2023-11-29T10:30:18.145Z\",\r\n"
				+ "        \"bpp_id\": \"sandbox.onest.network/adaptor-bpp/smartlab\",\r\n"
				+ "        \"bpp_uri\": \"https://sandbox.onest.network/adaptor-bpp/smartlab/bpp\"\r\n"
				+ "        },\r\n"
    			+ "        \"message\": {\r\n"
    			+ "          \"order\": {\r\n"
    			+ "            \"provider\": {\r\n"
    			+ "              \"id\": \"CEC\",\r\n"
    			+ "              \"descriptor\": {\r\n"
    			+ "                \"name\": \"CEC\"\r\n"
    			+ "              },\r\n"
    			+ "              \"category_id\": \"COMP_SCI_ENGG\"\r\n"
    			+ "            },\r\n"
    			+ "            \"items\": [\r\n"
    			+ "              {\r\n"
    			+ "                \"id\": \"Q291cnNlTGlzdDovbmQyX2NlYzIzX2NzMDI=\",\r\n"
    			+ "                \"parent_item_id\": \"Q291cnNlTGlzdDovbmQyX2NlYzIzX2NzMDI=\",\r\n"
    			+ "                \"descriptor\": {\r\n"
    			+ "                  \"name\": \"Problem solving Aspects and Python Programming\",\r\n"
    			+ "                  \"long_desc\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\",\r\n"
    			+ "                  \"images\": [\r\n"
    			+ "                    {\r\n"
    			+ "                      \"url\": \"https://storage.googleapis.com/swayam-node2-production.appspot.com/assets/img/cec20_cs04/Course%20Image.png\"\r\n"
    			+ "                    }\r\n"
    			+ "                  ]\r\n"
    			+ "                },\r\n"
    			+ "                \"price\": {\r\n"
    			+ "                  \"currency\": \"INR\",\r\n"
    			+ "                  \"value\": \"0\"\r\n"
    			+ "                },\r\n"
    			+ "                \"category_id\": \"COMP_SCI_ENGG\",\r\n"
    			+ "                \"recommended\": false,\r\n"
    			+ "                \"time\": {\r\n"
    			+ "                  \"label\": \"Course Schedule\",\r\n"
    			+ "                  \"duration\": \"P12W\",\r\n"
    			+ "                  \"range\": {\r\n"
    			+ "                    \"start\": \"2023-01-17T18:30:00.000000Z\",\r\n"
    			+ "                    \"end\": \"2023-04-09T18:29:00.000000Z\"\r\n"
    			+ "                  }\r\n"
    			+ "                },\r\n"
    			+ "                \"rating\": \"1\",\r\n"
    			+ "                \"tags\": [\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"courseDetails\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"credits\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"4\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"instructors\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"offeringInstitue\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Kongu Engineering College\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"url\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"enrollmentEndDate\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"2023-02-28T18:29:00.000000Z\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  },\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"eligibility\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion1\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion2\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion3\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"criterion4\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  },\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"courseHighlights\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight1\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight2\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight3\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"highlight4\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  },\r\n"
    			+ "                  {\r\n"
    			+ "                    \"descriptor\": {\r\n"
    			+ "                      \"name\": \"prerequisites\"\r\n"
    			+ "                    },\r\n"
    			+ "                    \"list\": [\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite1\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite2\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite3\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      },\r\n"
    			+ "                      {\r\n"
    			+ "                        \"descriptor\": {\r\n"
    			+ "                          \"name\": \"prerequisite4\"\r\n"
    			+ "                        },\r\n"
    			+ "                        \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\r\n"
    			+ "                      }\r\n"
    			+ "                    ],\r\n"
    			+ "                    \"display\": true\r\n"
    			+ "                  }\r\n"
    			+ "                ],\r\n"
    			+ "                \"rateable\": false\r\n"
    			+ "              }\r\n"
    			+ "            ],\r\n"
    			+ "            \"fulfillments\": [\r\n"
    			+ "              {\r\n"
    			+ "                \"customer\": {\r\n"
    			+ "                  \"person\": {\r\n"
    			+ "                    \"name\": \"John Doe\"\r\n"
    			+ "                  }\r\n"
    			+ "                },\r\n"
    			+ "                \"tracking\": false\r\n"
    			+ "              }\r\n"
    			+ "            ],\r\n"
    			+ "            \"id\": \"a9aaecca-10b7-4d19-b640-b047a7c621961676906777032\",\r\n"
    			+ "            \"state\": \"COMPLETE\",\r\n"
    			+ "            \"type\": \"DEFAULT\",\r\n"
    			+ "            \"created_at\": \"2023-02-20T15:26:17.032Z\",\r\n"
    			+ "            \"updated_at\": \"2023-02-20T15:26:17.032Z\"\r\n"
    			+ "          }\r\n"
    			+ "        }\r\n"
    			+ "      }";
    }


	public static String onSearch(Context ctx){
		return "{\r\n"+

		//return "{\n" +
				"  \"context\": {\n" +
				"    \"domain\": \""+ctx.getDomain()+"\",\n" +
				"    \"version\": \""+ctx.getCoreVersion()+"\",\n" +
				"    \"action\": \"on_search\",\n" +
				"    \"bap_id\": \""+ctx.getBapId()+"\",\n" +
				"    \"bap_uri\": \""+ctx.getBapUri()+"\",\n" +
				"    \"transaction_id\": \""+ctx.getTransactionId()+"\",\n" +
				"    \"message_id\": \""+ctx.getMessageId()+"\",\n" +
				"    \"ttl\": \"PT10M\",\n" +
				"    \"timestamp\": \"2023-11-30T07:17:08.9104609Z\",\n" +
				"    \"bpp_id\": \""+BPP_ID+"\",\n" +
				"    \"bpp_uri\": \""+BPP_URL+"\"\n" +
				"  },\n" +
				"  \"message\": {\n" +
				"    \"catalog\": {\n" +
				"      \"descriptor\": {\n" +
				"        \"name\": \"PtAgriLearning Catelog\"\n" +
				"      },\n" +
				"      \"providers\": [\n" +
				"        {\n" +
				"          \"id\": \"PtAgriLearning\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"PtAgriLearning\"\n" +
				"          },\n" +
				"          \"categories\": [\n" +
				"            {\n" +
				"              \"id\": \"5\",\n" +
				"              \"parent_category_id\": \"5\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Grains\"\n" +
				"              }\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"6\",\n" +
				"              \"parent_category_id\": \"6\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Vegetables\"\n" +
				"              }\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"4\",\n" +
				"              \"parent_category_id\": \"4\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Drip Farming\"\n" +
				"              }\n" +
				"            }\n" +
				"          ],\n" +
				"          \"items\": [\n" +
				"            {\n" +
				"              \"id\": \"281\",\n" +
				"              \"parent_item_id\": \"281\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Wheat grain farming\",\n" +
				"                \"long_desc\": \"Wheat is sown by four methods: broadcasting, behind the local plough, drilling and dibbling. The zero tillage technique is a new method of wheat cultivation that is used in the Rice-Wheat cropping system. Further Reading: Rabi and Kharif Crops\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231117065108057.jpg\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"5\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105128Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105128Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"282\",\n" +
				"              \"parent_item_id\": \"282\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Rice grain farming\",\n" +
				"                \"long_desc\": \"Rice is cultivated differently than other grains because it is a semi-aquatic plant that requires consistent irrigation all season to grow.  Heavy clay and silt loam soils that are often ill-suited to other crops retain water very well, making them perfect for rice\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231117065108057.jpg\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"5\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105128Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105128Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"283\",\n" +
				"              \"parent_item_id\": \"283\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Barley grain farming\",\n" +
				"                \"long_desc\": \"Barley farming\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231117065108057.jpg\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"5\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105128Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105128Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"284\",\n" +
				"              \"parent_item_id\": \"284\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Corn grain farming\",\n" +
				"                \"long_desc\": \"Corn is a tall annual cereal grass (Zea mays) that is widely grown for its large elongated ears of starchy seeds. The seeds, which are also known as corn, are used as food for humans and livestock and as a source of biofuel and can be processed into a wide range of useful chemicals\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231117065108057.jpg\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"5\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105128Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105128Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"285\",\n" +
				"              \"parent_item_id\": \"285\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Millet grain farming\",\n" +
				"                \"long_desc\": \"Millets are small - grained, annual, warm - weather cereals belonging to grass family. They are rain - fed, hardy grains which have low requirements of water and fertility when compared to other popular cereals. They are highly tolerant to drought and other extreme weather conditions\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231117065108057.jpg\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"5\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105128Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105128Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"241\",\n" +
				"              \"parent_item_id\": \"241\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Tomato Vegetable farming\",\n" +
				"                \"long_desc\": \"The tomato fruit is globular or ovoid. Botanically, the fruit exhibits all of the common characteristics of berries; a simple fleshy fruit that encloses its seed in the pulp. The outer skin is a thin and fleshy tissue that comprises the remainder of the fruit wall as well as the placenta\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231027160100911.png\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"6\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105151Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105151Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"242\",\n" +
				"              \"parent_item_id\": \"242\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Cauliflower Vegetable farming\",\n" +
				"                \"long_desc\": \"Cauliflowers are annual plants that reach about 0.5 metre (1.5 feet) tall and bear large rounded leaves that resemble collards (Brassica oleracea, variety acephala). As desired for food, the terminal cluster forms a firm, succulent “curd,” or head, that is an immature inflorescence (cluster of flowers).\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231027160100911.png\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"6\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105151Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105151Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"243\",\n" +
				"              \"parent_item_id\": \"243\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Cabbage Vegetable farming\",\n" +
				"                \"long_desc\": \"Cabbage farming\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231027160100911.png\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"6\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105151Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105151Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"244\",\n" +
				"              \"parent_item_id\": \"244\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Brinjal Vegetable farming\",\n" +
				"                \"long_desc\": \"Brinjal is a hardy crop than other vegetables. Due to its hardness, it can be successfully grown in dry area with low irrigation facilities. It is moderate source of Vitamins and minerals. It can grow throughout the year.\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231027160100911.png\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"6\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105151Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105151Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"245\",\n" +
				"              \"parent_item_id\": \"245\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Ladyfinger\",\n" +
				"                \"long_desc\": \"Okra or Ladies Finger is an annual plant belongs to the family Malvaceae. The place of origin is Ethiopia, it is mainly grown in tropical and sub-tropical regions. The major growing states in India are Uttar Pradesh, Bihar, West Bengal and Orissa. Okra is mainly grown for its green tender nutritive fruits.\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231123122909294.jpg\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"6\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105156Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105156Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            },\n" +
				"            {\n" +
				"              \"id\": \"220\",\n" +
				"              \"parent_item_id\": \"220\",\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"Drip farming\",\n" +
				"                \"long_desc\": \"Drip farming\",\n" +
				"                \"images\": [\n" +
				"                  {\n" +
				"                    \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231018181517660.jpg\"\n" +
				"                  }\n" +
				"                ]\n" +
				"              },\n" +
				"              \"price\": {\n" +
				"                \"currency\": \"INR\",\n" +
				"                \"value\": \"500\"\n" +
				"              },\n" +
				"              \"category_id\": \"4\",\n" +
				"              \"recommended\": false,\n" +
				"              \"time\": {\n" +
				"                \"label\": \"Course Schedule\",\n" +
				"                \"duration\": \"P2M\",\n" +
				"                \"range\": {\n" +
				"                  \"start\": \"2023-11-30T07:17:08.9105161Z\",\n" +
				"                  \"end\": \"2024-01-30T07:17:08.9105161Z\"\n" +
				"                }\n" +
				"              },\n" +
				"              \"rating\": \"5\",\n" +
				"              \"tags\": null,\n" +
				"              \"rateable\": false\n" +
				"            }\n" +
				"          ]\n" +
				"        }\n" +
				"      ]\n" +
				"    }\n" +
				"  }\r\n" +
				"}";

		//+ "        }\r\n"

	}

	public static String onSelect(Context ctx) {
		return "{\r\n"+

				//return "{\n" +
				"  \"context\": {\n" +
				"    \"domain\": \""+ctx.getDomain()+"\",\n" +
				"    \"version\": \""+ctx.getCoreVersion()+"\",\n" +
				"    \"action\": \"on_select\",\n" +
				"    \"bap_id\": \""+ctx.getBapId()+"\",\n" +
				"    \"bap_uri\": \""+ctx.getBapUri()+"\",\n" +
				"    \"transaction_id\": \""+ctx.getTransactionId()+"\",\n" +
				"    \"message_id\": \""+ctx.getMessageId()+"\",\n" +
				"    \"ttl\": \"PT10M\",\n" +
				"    \"timestamp\": \"2023-11-30T07:17:08.9104609Z\",\n" +
				"    \"bpp_id\": \""+BPP_ID+"\",\n" +
				"    \"bpp_uri\": \""+BPP_URL+"\"\n" +
				"  },\n" +
				"  \"message\": {\n" +
				"    \"order\": {\n" +
				"      \"provider\": {\n" +
				"        \"id\": \"PtAgriLearning\",\n" +
				"        \"descriptor\": {\n" +
				"          \"name\": \"PtAgriLearning\"\n" +
				"        },\n" +
				"        \"category_id\": \"5\"\n" +
				"      },\n" +
				"      \"items\": [\n" +
				"\n" +
				"        {\n" +
				"          \"id\": \"281\",\n" +
				"          \"parent_item_id\": \"281\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Wheat grain farming\",\n" +
				"            \"long_desc\": \"Wheat is sown by four methods: broadcasting, behind the local plough, drilling and dibbling. The zero tillage technique is a new method of wheat cultivation that is used in the Rice-Wheat cropping system. Further Reading: Rabi and Kharif Crops\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231117065108057.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105128Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105128Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"282\",\n" +
				"          \"parent_item_id\": \"282\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Rice grain farming\",\n" +
				"            \"long_desc\": \"Rice is cultivated differently than other grains because it is a semi-aquatic plant that requires consistent irrigation all season to grow.  Heavy clay and silt loam soils that are often ill-suited to other crops retain water very well, making them perfect for rice\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231117065108057.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105128Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105128Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"283\",\n" +
				"          \"parent_item_id\": \"283\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Barley grain farming\",\n" +
				"            \"long_desc\": \"Barley farming\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231117065108057.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105128Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105128Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"284\",\n" +
				"          \"parent_item_id\": \"284\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Corn grain farming\",\n" +
				"            \"long_desc\": \"Corn framing\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231117065108057.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105128Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105128Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"285\",\n" +
				"          \"parent_item_id\": \"285\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Millet grain farming\",\n" +
				"            \"long_desc\": \"Millet farming\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231117065108057.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105128Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105128Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"241\",\n" +
				"          \"parent_item_id\": \"241\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Tomato Vegetable farming\",\n" +
				"            \"long_desc\": \"Tomato farming\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231027160100911.png\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105151Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105151Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"242\",\n" +
				"          \"parent_item_id\": \"242\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Cauliflower Vegetable farming\",\n" +
				"            \"long_desc\": \"Cauliflower Vegetable farming\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231027160100911.png\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105151Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105151Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"243\",\n" +
				"          \"parent_item_id\": \"243\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Cabbage Vegetable farming\",\n" +
				"            \"long_desc\": \"Cabbage farming\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231027160100911.png\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105151Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105151Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"244\",\n" +
				"          \"parent_item_id\": \"244\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Brinjal Vegetable farming\",\n" +
				"            \"long_desc\": \"Brinjal farming\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231027160100911.png\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105151Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105151Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"245\",\n" +
				"          \"parent_item_id\": \"245\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Ladyfinger\",\n" +
				"            \"long_desc\": \"Ladyfinger farming\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231123122909294.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105156Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105156Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"220\",\n" +
				"          \"parent_item_id\": \"220\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Drip farming\",\n" +
				"            \"long_desc\": \"Drip farming\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://storage.googleapis.com/smlabs-gallery/CourseImages/20231018181517660.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"500\"\n" +
				"          },\n" +
				"          \"category_id\": \"4\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P2M\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-11-30T07:17:08.9105161Z\",\n" +
				"              \"end\": \"2024-01-30T07:17:08.9105161Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": null,\n" +
				"          \"rateable\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"type\": null\n" +
				"    }\n" +
				"  }\r\n" +
				"}";
	}

	public static String onInit_cat_5_grain_response(Context ctx) {

		return "{\r\n"+
				"  \"context\": {\n" +
				"    \"domain\": \""+ctx.getDomain()+"\",\n" +
				"    \"version\": \""+ctx.getCoreVersion()+"\",\n" +
				"    \"action\": \"on_init\",\n" +
				"    \"bap_id\": \""+ctx.getBapId()+"\",\n" +
				"    \"bap_uri\": \""+ctx.getBapUri()+"\",\n" +
				"    \"transaction_id\": \""+ctx.getTransactionId()+"\",\n" +
				"    \"message_id\": \""+ctx.getMessageId()+"\",\n" +
				"    \"ttl\": \"PT10M\",\n" +
				"    \"timestamp\": \"2023-11-30T07:17:08.9104609Z\",\n" +
				"    \"bpp_id\": \""+BPP_ID+"\",\n" +
				"    \"bpp_uri\": \""+BPP_URL+"\"\n" +
				"  },\n" +
				"  \"message\": {\n" +
				"    \"order\": {\n" +
				"      \"provider\": {\n" +
				"        \"id\": \"PtAgriLearning\",\n" +
				"        \"descriptor\": {\n" +
				"          \"name\": \"PtAgriLearning\"\n" +
				"        },\n" +
				"        \"category_id\": \"5\"\n" +
				"      },\n" +
				"      \"items\": [\n" +
				"        {\n" +
				"          \"id\": \"285\",\n" +
				"          \"parent_item_id\": \"285\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Millet Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Grain farming refers to growing grain crops and grain seeds to harvest their seeds at the end of the growing season. The main types of grain farming are dry pea and bean farming, wheat farming, and other types. Wheat farming refers to a cereal crop that is grown for food.\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=E1FQ3QcWHR4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/8b/9f/17/8b9f17943f53dab4aa225b9235552ab2.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"282\",\n" +
				"          \"parent_item_id\": \"282\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Rice Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Grain farming refers to growing grain crops and grain seeds to harvest their seeds at the end of the growing season. The main types of grain farming are dry pea and bean farming, wheat farming, and other types. Wheat farming refers to a cereal crop that is grown for food.\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=7w0XuoqvCFg\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/736x/02/e7/94/02e794a41fcd469c7440c2cc54a6ca33.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"284\",\n" +
				"          \"parent_item_id\": \"284\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Corn Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Grain farming refers to growing grain crops and grain seeds to harvest their seeds at the end of the growing season. The main types of grain farming are dry pea and bean farming, wheat farming, and other types. Wheat farming refers to a cereal crop that is grown for food.\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=nfMLKP1nXK0\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/736x/94/f8/ec/94f8ec1048034727684c9218150015fb.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"283\",\n" +
				"          \"parent_item_id\": \"283\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Barley Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Grain farming refers to growing grain crops and grain seeds to harvest their seeds at the end of the growing season. The main types of grain farming are dry pea and bean farming, wheat farming, and other types. Wheat farming refers to a cereal crop that is grown for food.\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=AHxz9DRstsI\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/5d/4b/82/5d4b82c1bdb295b026ee9c27aed98265.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"281\",\n" +
				"          \"parent_item_id\": \"281\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Wheat Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Wheat farming refers to growing grain crops and grain seeds to harvest their seeds at the end of the growing season. The main types of grain farming are dry pea and bean farming, wheat farming, and other types. Wheat farming refers to a cereal crop that is grown for food.\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=AHxz9DRstsI\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/04/cd/b3/04cdb36511c293c59f339d0ae7f232a2.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"fulfillments\": [\n" +
				"        {\n" +
				"          \"customer\": {\n" +
				"            \"person\": {\n" +
				"              \"name\": \"John Doe\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"tracking\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"type\": \"DEFAULT\"\n" +
				"    }\n" +
				"  }\n" +
				"}";
	}

	public static String onInit_cat_6_vegetables_response(Context ctx) {

		return "{\r\n"+
				"  \"context\": {\n" +
				"    \"domain\": \""+ctx.getDomain()+"\",\n" +
				"    \"version\": \""+ctx.getCoreVersion()+"\",\n" +
				"    \"action\": \"on_init\",\n" +
				"    \"bap_id\": \""+ctx.getBapId()+"\",\n" +
				"    \"bap_uri\": \""+ctx.getBapUri()+"\",\n" +
				"    \"transaction_id\": \""+ctx.getTransactionId()+"\",\n" +
				"    \"message_id\": \""+ctx.getMessageId()+"\",\n" +
				"    \"ttl\": \"PT10M\",\n" +
				"    \"timestamp\": \"2023-11-30T07:17:08.9104609Z\",\n" +
				"    \"bpp_id\": \""+BPP_ID+"\",\n" +
				"    \"bpp_uri\": \""+BPP_URL+"\"\n" +
				"  },\n" +
				"  \"message\": {\n" +
				"    \"order\": {\n" +
				"      \"provider\": {\n" +
				"        \"id\": \"PtAgriLearning\",\n" +
				"        \"descriptor\": {\n" +
				"          \"name\": \"PtAgriLearning\"\n" +
				"        },\n" +
				"        \"category_id\": \"6\"\n" +
				"      },\n" +
				"      \"items\": [\n" +
				"        {\n" +
				"          \"id\": \"241\",\n" +
				"          \"parent_item_id\": \"241\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Tomato Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Vegetables farming irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=L_O3vpTHM1o\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/c5/53/71/c55371e9e8f4d910877a9e714033bfca.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"244\",\n" +
				"          \"parent_item_id\": \"244\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Brinjal Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Vegetables farming irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=LAjpI6ylvVM\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/5e/ce/e0/5ecee02431e9418572c66680c5bc3c25.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"245\",\n" +
				"          \"parent_item_id\": \"245\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Lady finger Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Vegetables farming irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=DXJkTerZ_ac\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/01/e2/e4/01e2e4ece53044885f7135bdf8c3f330.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"243\",\n" +
				"          \"parent_item_id\": \"243\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Cabbage Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Vegetables farming irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/shorts/sM7SIL10xlU\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/25/b8/89/25b889ab7b59e544731026cee7cabed1.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"242\",\n" +
				"          \"parent_item_id\": \"242\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Cauliflower Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Vegetables farming irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/shorts/07sBW6SnZcY\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/ce/b4/d8/ceb4d87d8a2aac7997b22bfa64ec063d.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"fulfillments\": [\n" +
				"        {\n" +
				"          \"customer\": {\n" +
				"            \"person\": {\n" +
				"              \"name\": \"John Doe\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"tracking\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"type\": \"DEFAULT\"\n" +
				"    }\n" +
				"  }\n" +
				"}";
	}

	public static String onInit_cat_4_drip_response(Context ctx) {

		return "{\r\n"+
				"  \"context\": {\n" +
				"    \"domain\": \""+ctx.getDomain()+"\",\n" +
				"    \"version\": \""+ctx.getCoreVersion()+"\",\n" +
				"    \"action\": \"on_init\",\n" +
				"    \"bap_id\": \""+ctx.getBapId()+"\",\n" +
				"    \"bap_uri\": \""+ctx.getBapUri()+"\",\n" +
				"    \"transaction_id\": \""+ctx.getTransactionId()+"\",\n" +
				"    \"message_id\": \""+ctx.getMessageId()+"\",\n" +
				"    \"ttl\": \"PT10M\",\n" +
				"    \"timestamp\": \"2023-11-30T07:17:08.9104609Z\",\n" +
				"    \"bpp_id\": \""+BPP_ID+"\",\n" +
				"    \"bpp_uri\": \""+BPP_URL+"\"\n" +
				"  },\n" +
				"  \"message\": {\n" +
				"    \"order\": {\n" +
				"      \"provider\": {\n" +
				"        \"id\": \"PtAgriLearning\",\n" +
				"        \"descriptor\": {\n" +
				"          \"name\": \"PtAgriLearning\"\n" +
				"        },\n" +
				"        \"category_id\": \"4\"\n" +
				"      },\n" +
				"      \"items\": [\n" +
				"        {\n" +
				"          \"id\": \"220\",\n" +
				"          \"parent_item_id\": \"220\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Drip Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Drip irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"4\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"links\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/shorts/Rqb7ZqmhqfY\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"fulfillments\": [\n" +
				"        {\n" +
				"          \"customer\": {\n" +
				"            \"person\": {\n" +
				"              \"name\": \"John Doe\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"tracking\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"type\": \"DEFAULT\"\n" +
				"    }\n" +
				"  }\n" +
				"}";
	}

	public static String onConfirm_cat_5_grains_response(Context ctx) {
		return "{\r\n"+
				"  \"context\": {\n" +
				"    \"domain\": \""+ctx.getDomain()+"\",\n" +
				"    \"version\": \""+ctx.getCoreVersion()+"\",\n" +
				"    \"action\": \"on_confirm\",\n" +
				"    \"bap_id\": \""+ctx.getBapId()+"\",\n" +
				"    \"bap_uri\": \""+ctx.getBapUri()+"\",\n" +
				"    \"transaction_id\": \""+ctx.getTransactionId()+"\",\n" +
				"    \"message_id\": \""+ctx.getMessageId()+"\",\n" +
				"    \"ttl\": \"PT10M\",\n" +
				"    \"timestamp\": \"2023-11-30T07:17:08.9104609Z\",\n" +
				"    \"bpp_id\": \""+BPP_ID+"\",\n" +
				"    \"bpp_uri\": \""+BPP_URL+"\"\n" +
				"  },\n" +
				"  \"message\": {\n" +
				"    \"order\": {\n" +
				"      \"provider\": {\n" +
				"        \"id\": \"PtAgriLearning\",\n" +
				"        \"descriptor\": {\n" +
				"          \"name\": \"PtAgriLearning\"\n" +
				"        },\n" +
				"        \"category_id\": \"5\"\n" +
				"      },\n" +
				"      \"items\": [\n" +
				"        {\n" +
				"          \"id\": \"285\",\n" +
				"          \"parent_item_id\": \"285\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Millet Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Grain farming refers to growing grain crops and grain seeds to harvest their seeds at the end of the growing season. The main types of grain farming are dry pea and bean farming, wheat farming, and other types. Wheat farming refers to a cereal crop that is grown for food.\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=E1FQ3QcWHR4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/8b/9f/17/8b9f17943f53dab4aa225b9235552ab2.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"282\",\n" +
				"          \"parent_item_id\": \"282\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Rice Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Grain farming refers to growing grain crops and grain seeds to harvest their seeds at the end of the growing season. The main types of grain farming are dry pea and bean farming, wheat farming, and other types. Wheat farming refers to a cereal crop that is grown for food.\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=7w0XuoqvCFg\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/736x/02/e7/94/02e794a41fcd469c7440c2cc54a6ca33.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"284\",\n" +
				"          \"parent_item_id\": \"284\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Corn Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Grain farming refers to growing grain crops and grain seeds to harvest their seeds at the end of the growing season. The main types of grain farming are dry pea and bean farming, wheat farming, and other types. Wheat farming refers to a cereal crop that is grown for food.\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=nfMLKP1nXK0\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/736x/94/f8/ec/94f8ec1048034727684c9218150015fb.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"283\",\n" +
				"          \"parent_item_id\": \"283\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Barley Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Grain farming refers to growing grain crops and grain seeds to harvest their seeds at the end of the growing season. The main types of grain farming are dry pea and bean farming, wheat farming, and other types. Wheat farming refers to a cereal crop that is grown for food.\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=AHxz9DRstsI\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/5d/4b/82/5d4b82c1bdb295b026ee9c27aed98265.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"281\",\n" +
				"          \"parent_item_id\": \"281\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Wheat Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Wheat farming refers to growing grain crops and grain seeds to harvest their seeds at the end of the growing season. The main types of grain farming are dry pea and bean farming, wheat farming, and other types. Wheat farming refers to a cereal crop that is grown for food.\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"5\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=AHxz9DRstsI\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/04/cd/b3/04cdb36511c293c59f339d0ae7f232a2.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"fulfillments\": [\n" +
				"        {\n" +
				"          \"customer\": {\n" +
				"            \"person\": {\n" +
				"              \"name\": \"John Doe\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"tracking\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"type\": \"DEFAULT\"\n" +
				"    }\n" +
				"  }\n" +
				"}";
	}

	public static String onConfirm_cat_6_vegetables_response(Context ctx) {
		return "{\r\n"+
				"  \"context\": {\n" +
				"    \"domain\": \""+ctx.getDomain()+"\",\n" +
				"    \"version\": \""+ctx.getCoreVersion()+"\",\n" +
				"    \"action\": \"on_confirm\",\n" +
				"    \"bap_id\": \""+ctx.getBapId()+"\",\n" +
				"    \"bap_uri\": \""+ctx.getBapUri()+"\",\n" +
				"    \"transaction_id\": \""+ctx.getTransactionId()+"\",\n" +
				"    \"message_id\": \""+ctx.getMessageId()+"\",\n" +
				"    \"ttl\": \"PT10M\",\n" +
				"    \"timestamp\": \"2023-11-30T07:17:08.9104609Z\",\n" +
				"    \"bpp_id\": \""+BPP_ID+"\",\n" +
				"    \"bpp_uri\": \""+BPP_URL+"\"\n" +
				"  },\n" +
				"  \"message\": {\n" +
				"    \"order\": {\n" +
				"      \"provider\": {\n" +
				"        \"id\": \"PtAgriLearning\",\n" +
				"        \"descriptor\": {\n" +
				"          \"name\": \"PtAgriLearning\"\n" +
				"        },\n" +
				"        \"category_id\": \"6\"\n" +
				"      },\n" +
				"      \"items\": [\n" +
				"        {\n" +
				"          \"id\": \"241\",\n" +
				"          \"parent_item_id\": \"241\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Tomato Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Vegetables farming irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=L_O3vpTHM1o\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/c5/53/71/c55371e9e8f4d910877a9e714033bfca.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"244\",\n" +
				"          \"parent_item_id\": \"244\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Brinjal Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Vegetables farming irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=LAjpI6ylvVM\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/5e/ce/e0/5ecee02431e9418572c66680c5bc3c25.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"245\",\n" +
				"          \"parent_item_id\": \"245\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Lady finger Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Vegetables farming irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/watch?v=DXJkTerZ_ac\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/01/e2/e4/01e2e4ece53044885f7135bdf8c3f330.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"243\",\n" +
				"          \"parent_item_id\": \"243\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Cabbage Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Vegetables farming irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/shorts/sM7SIL10xlU\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/25/b8/89/25b889ab7b59e544731026cee7cabed1.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": \"242\",\n" +
				"          \"parent_item_id\": \"242\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Cauliflower Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Vegetables farming irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"6\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/shorts/07sBW6SnZcY\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/ce/b4/d8/ceb4d87d8a2aac7997b22bfa64ec063d.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"fulfillments\": [\n" +
				"        {\n" +
				"          \"customer\": {\n" +
				"            \"person\": {\n" +
				"              \"name\": \"John Doe\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"tracking\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"type\": \"DEFAULT\"\n" +
				"    }\n" +
				"  }\n" +
				"}";
	}

	public static String onConfirm_cat_4_drip_response(Context ctx) {
		return "{\r\n"+
				"  \"context\": {\n" +
				"    \"domain\": \""+ctx.getDomain()+"\",\n" +
				"    \"version\": \""+ctx.getCoreVersion()+"\",\n" +
				"    \"action\": \"on_confirm\",\n" +
				"    \"bap_id\": \""+ctx.getBapId()+"\",\n" +
				"    \"bap_uri\": \""+ctx.getBapUri()+"\",\n" +
				"    \"transaction_id\": \""+ctx.getTransactionId()+"\",\n" +
				"    \"message_id\": \""+ctx.getMessageId()+"\",\n" +
				"    \"ttl\": \"PT10M\",\n" +
				"    \"timestamp\": \"2023-11-30T07:17:08.9104609Z\",\n" +
				"    \"bpp_id\": \""+BPP_ID+"\",\n" +
				"    \"bpp_uri\": \""+BPP_URL+"\"\n" +
				"  },\n" +
				"  \"message\": {\n" +
				"    \"order\": {\n" +
				"      \"provider\": {\n" +
				"        \"id\": \"PtAgriLearning\",\n" +
				"        \"descriptor\": {\n" +
				"          \"name\": \"PtAgriLearning\"\n" +
				"        },\n" +
				"        \"category_id\": \"4\"\n" +
				"      },\n" +
				"      \"items\": [\n" +
				"        {\n" +
				"          \"id\": \"220\",\n" +
				"          \"parent_item_id\": \"220\",\n" +
				"          \"descriptor\": {\n" +
				"            \"name\": \"Drip Farming - Starter Course\",\n" +
				"            \"long_desc\": \"Drip irrigation involves placing tubing with emitters on the ground along side the plants. The emitters slowly drip water into the soil at the root zone. Because moisture levels are kept at an optimal range, plant productivity and quality improve\",\n" +
				"            \"images\": [\n" +
				"              {\n" +
				"                \"url\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"              }\n" +
				"            ]\n" +
				"          },\n" +
				"          \"price\": {\n" +
				"            \"currency\": \"INR\",\n" +
				"            \"value\": \"0\"\n" +
				"          },\n" +
				"          \"category_id\": \"4\",\n" +
				"          \"recommended\": false,\n" +
				"          \"time\": {\n" +
				"            \"label\": \"Course Schedule\",\n" +
				"            \"duration\": \"P12W\",\n" +
				"            \"range\": {\n" +
				"              \"start\": \"2023-01-17T18:30:00.000000Z\",\n" +
				"              \"end\": \"2023-04-09T18:29:00.000000Z\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"rating\": \"5\",\n" +
				"          \"tags\": [\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseDetails\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"credits\"\n" +
				"                  },\n" +
				"                  \"value\": \"4\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"instructors\"\n" +
				"                  },\n" +
				"                  \"value\": \"Dr.S.Malliga, Dr.R.Thangarajan, Dr.S.V.Kogilavani\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"offeringInstitue\"\n" +
				"                  },\n" +
				"                  \"value\": \"Kongu Engineering College\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"url\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://onlinecourses.swayam2.ac.in/cec23_cs02/preview\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"enrollmentEndDate\"\n" +
				"                  },\n" +
				"                  \"value\": \"2023-02-28T18:29:00.000000Z\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"media\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"video\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://www.youtube.com/shorts/Rqb7ZqmhqfY\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"image\"\n" +
				"                  },\n" +
				"                  \"value\": \"https://i.pinimg.com/564x/86/01/e0/8601e04eceaa501a887dcd7eb6525421.jpg\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"eligibility\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"criterion4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"courseHighlights\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"highlight4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            },\n" +
				"            {\n" +
				"              \"descriptor\": {\n" +
				"                \"name\": \"prerequisites\"\n" +
				"              },\n" +
				"              \"list\": [\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite1\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite2\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite3\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                },\n" +
				"                {\n" +
				"                  \"descriptor\": {\n" +
				"                    \"name\": \"prerequisite4\"\n" +
				"                  },\n" +
				"                  \"value\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\"\n" +
				"                }\n" +
				"              ],\n" +
				"              \"display\": true\n" +
				"            }\n" +
				"          ],\n" +
				"          \"rateable\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"fulfillments\": [\n" +
				"        {\n" +
				"          \"customer\": {\n" +
				"            \"person\": {\n" +
				"              \"name\": \"John Doe\"\n" +
				"            }\n" +
				"          },\n" +
				"          \"tracking\": false\n" +
				"        }\n" +
				"      ],\n" +
				"      \"type\": \"DEFAULT\"\n" +
				"    }\n" +
				"  }\n" +
				"}";
	}
}
