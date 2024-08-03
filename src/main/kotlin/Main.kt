fun main(args: Array<String>) {

    //val downloadListener = App()
    val downloader = Downloader()
    //downloader.downloadListener = downloadListener

    //Object expression has been used below
    downloader.downloadListener = object:DownloadListener{
        override fun onDownloadStarted() {
            println("Download Started")
        }

        override fun onProgressUpdated(progress: Int) {
            println("$progress % On progress")
        }

        override fun onDownloadCompleted(file: String) {
            println("$file Download completed")
        }

    }

    downloader.downloadFile("File.mkv")
}


interface DownloadListener{

    fun onDownloadStarted()
    fun onProgressUpdated(progress:Int)
    fun onDownloadCompleted(file: String)
}
class Downloader{

    var downloadListener : DownloadListener? = null
    fun downloadFile(file:String){
        downloadListener?.onDownloadStarted()

        for(i in 1..10){
            Thread.sleep(600)
            downloadListener?.onProgressUpdated(i * 10)
        }
        downloadListener?.onDownloadCompleted(file)
    }
}

//class App:DownloadListener{
//
//    override fun onDownloadStarted(){
//        println("Download Started")
//    }
//
//    override fun onProgressUpdated(progress: Int) {
//
//        println("$progress % On progress")
//    }
//
//    override fun onDownloadCompleted(file: String) {
//        println("$file Download completed")
//    }
//}