/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.exoplayer.upstream;

/**
 * A source of allocations.
 */
public interface Allocator {

  /**
   * Obtain a buffer from the allocator.
   * <p>
   * When the caller has finished with the buffer, it should be returned by calling
   * {@link #releaseBuffer(byte[])}.
   *
   * @return The allocated buffer.
   */
  byte[] allocateBuffer();

  /**
   * Return a buffer to the allocator.
   *
   * @param buffer The buffer being returned.
   */
  void releaseBuffer(byte[] buffer);

  /**
   * Hints to the {@link Allocator} that it should make a best effort to release any memory that it
   * has allocated, beyond the specified target number of bytes.
   *
   * @param targetSize The target size in bytes.
   */
  void trim(int targetSize);

  /**
   * Returns the total size of all allocated buffers.
   */
  int getAllocatedSize();

  /**
   * Returns the length of each buffer provided by the allocator.
   */
  int getBufferLength();

}
