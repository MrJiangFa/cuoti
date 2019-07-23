package design_parttern;

/**
<<<<<<< HEAD
 * 适配器是作为两个不兼容的接口之间的桥梁，结合了两个独立接口的功能
 * 应用场景：将现存的对象放到新的环境中，而新环境要求的接口先对象无法满足；
 *
 *
 */
public class AdapterPattern {
=======
 * 优点：让两个没有任何关联的类一起运行；提高类的复用；
 * 应用场景：有动机的修改一个正常运行的系统接口
 */
public class AdapterPattern {
    interface MediaPlayer {
        void play(String audioType, String filename);
    }

    static class AudioPlayer implements MediaPlayer {
        @Override
        public void play(String audioType, String filename) {
            System.out.println("播放.mp3文件");
        }
    }

    interface AdvancdedMediaPlayer {
        void play(String filename);
    }

    static class VideoPlayer implements AdvancdedMediaPlayer {
        @Override
        public void play(String filename) {
            System.out.println("播放.mp4,.vlc文件");
        }
    }

    /**
     * MediaPlayer的适配器类MediaAdapter，使用AdvancedMediaPlay对象来播放所需的格式
     */
    static class MediaAdapter implements MediaPlayer {
        AdvancdedMediaPlayer advancdedMediaPlayer;

        public MediaAdapter(String audioType) {
            advancdedMediaPlayer = new VideoPlayer();
        }

        @Override
        public void play(String name, String fileName) {
            if (name.equalsIgnoreCase("mp4")) {
                advancdedMediaPlayer.play(fileName);
            } else if (name.equalsIgnoreCase("vlc")) {
                advancdedMediaPlayer.play(fileName);
            }
        }
    }

>>>>>>> 40ef39e271317874e3d364ab18df604999d9f2b1

}
