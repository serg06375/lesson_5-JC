package App;


                public class Main {

                public static void main(String[] args) throws IOException, FileNotFoundException {

                File file = new File("hw5.csv");
                AppData appData = new AppData();

                int counterOfLines = 0;
                int counterOfElements = 0;
                try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                    counterOfElements = in.readLine().split(";").length;
                    String result = null;
                    while ((result = in.readLine()) != null)
                        counterOfLines++;
                }
                catch (IOException e){e.printStackTrace();}

                int[][] data = new int[counterOfLines][counterOfElements];

                try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                    String[] result = null;

                    appData.setHeader(in.readLine().split(";").clone());

                    for(int i = 0; i < counterOfLines; i++){
                        result = in.readLine().split(";");
                        for(int j = 0; j < counterOfElements; j++) {
                            data[i][j] = Integer.parseInt(result[j]);
                        }
                    }
                    appData.setData(data);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                for(String s: appData.getHeader())
                    System.out.println(s);

                for(int[] arr: appData.getData())
                    for(int i: arr)
                        System.out.println(i);

            }


        }


