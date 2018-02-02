LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := app
LOCAL_SRC_FILES := Main.cpp

include $(BUILD_SHARED_LIBRARY)