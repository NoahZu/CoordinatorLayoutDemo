//
// Created by 俎金好 on 2018/2/2.
//

#include "com_example_zujinhao_test_test_Test.h"

JNIEXPORT jstring JNICALL Java_com_example_zujinhao_test_test_Test_getString
        (JNIEnv *env, jclass){
    return env -> NewStringUTF("I am from native");
}