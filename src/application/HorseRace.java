package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class HorseRace extends Application {
	
	private final static int WIDTH = 800;
	private final static int LENGTH = 600;
	
	class HorseRunnable implements Runnable {
		private ImageView iv;
		
		public HorseRunnable(ImageView iv) {
			this.iv = iv;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < WIDTH; i++) {			
				//System.out.println(Thread.currentThread().getName() + ": " + i);
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				iv.setX(iv.getX() + 1);
			}
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		Group group = new Group();
		Image image = new Image("horse.png");
		ImageView imageView = new ImageView(image);
		group.getChildren().add(imageView);
		
		Image image2 = new Image("horse.png");
		ImageView imageView2 = new ImageView(image2);
		group.getChildren().add(imageView2);
		imageView2.setY(image.getHeight() + 20);		
		
		Scene scene = new Scene(group, WIDTH, LENGTH);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Horse Race");
		primaryStage.show();
		
		Thread thread1 = new Thread(new HorseRunnable(imageView));
		Thread thread2 = new Thread(new HorseRunnable(imageView2));
		thread1.start();
		thread2.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
