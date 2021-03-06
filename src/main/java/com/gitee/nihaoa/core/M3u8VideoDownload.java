package com.gitee.nihaoa.core;

import com.gitee.nihaoa.entry.VideoMeta;
import java.util.List;

public class M3u8VideoDownload {

  private VideoListFilter videoListFilter;
  private Downloader downloader;

  public M3u8VideoDownload(int threadCount) {
    downloader = new Downloader(threadCount);
  }

  public void setVideoListFilter(VideoListFilter filter) {
    videoListFilter = filter;
  }

  public void startDownload(String url, String fileName, String filePath){
    UrlParseInit urlParseInit = new UrlParseInit(url, filePath, fileName);
    urlParseInit.initUrl();
    List<VideoMeta> videoMetaList = urlParseInit.parseVideoFile();
    if (videoListFilter == null){
      videoListFilter = new DefaultVideoFilter();
    }
    VideoMeta selectVideo;
    if (videoMetaList.size() > 1){
      selectVideo = videoListFilter.filter(videoMetaList);
    }else {
      selectVideo = videoMetaList.get(0);
    }
    startDownload(selectVideo);
  }

  public void startDownload(VideoMeta videoMeta){
    downloader.downloadVideo(videoMeta);
  }
}
