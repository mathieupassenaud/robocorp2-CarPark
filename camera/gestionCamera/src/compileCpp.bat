del D:\workspace\detectionParking\src\jni\gestionCamera.dll
del D:\workspace\detectionParking\bin\gestionCamera.dll
del D:\workspace\detectionParking\bin\jni\gestionCamera.dll
del D:\workspace\gestionCamera\src\gestionCamera.dll
del D:\images\*.jpg
del D:\images\foreground\*.jpg
gcc -Wl,--add-stdcall-alias -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -I"D:\\OpenCV3\\opencv\\build\\include" -I"D:\workspace\gestionCamera\src" -L"D:\\OpenCV3\\opencv\\build\\x86\\mingw\\bin" -shared -o gestionCamera.dll gestionCamera.cpp -lopencv_calib3d300 -lopencv_core300 -lopencv_features2d300 -lopencv_flann300 -lopencv_highgui300 -lopencv_imgcodecs300 -lopencv_imgproc300 -lopencv_ml300 -lopencv_objdetect300 -lopencv_photo300 -lopencv_shape300 -lopencv_stitching300 -lopencv_superres300 -lopencv_video300 -lopencv_videoio300 -lopencv_videostab300 -lopencv_ffmpeg300 -lstdc++
copy gestionCamera.dll D:\workspace\detectionParking\src\jni\gestionCamera.dll
copy gestionCamera.dll D:\workspace\detectionParking\bin\gestionCamera.dll
copy gestionCamera.dll D:\workspace\detectionParking\bin\jni\gestionCamera.dll
cd D:\workspace\detectionParking\bin