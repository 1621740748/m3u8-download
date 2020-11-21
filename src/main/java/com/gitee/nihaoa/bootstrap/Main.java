package com.gitee.nihaoa.bootstrap;

import com.gitee.nihaoa.core.M3u8VideoDownload;

public class Main {
  public static void main(String[] args) throws Exception{
    M3u8VideoDownload videoDownload = new M3u8VideoDownload(10);
    String url=args[0];
    int index=url.lastIndexOf("/");
    String fileName=url.substring(index+1);
    videoDownload.startDownload(url, fileName, "./");
  }
}
