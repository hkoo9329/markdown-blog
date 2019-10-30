package com.hkoo.markdownblog.repository;

import com.hkoo.markdownblog.domain.Thumbnail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThumbnailRepository extends JpaRepository<Thumbnail,Long> {
}
